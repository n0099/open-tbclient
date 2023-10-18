package com.baidu.tieba.frs.voiceroom.data;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VoiceRoom;
@Keep
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "", "voiceRoom", "Ltbclient/VoiceRoom;", "forumName", "", "(Ltbclient/VoiceRoom;Ljava/lang/String;)V", "getForumName", "()Ljava/lang/String;", "getVoiceRoom", "()Ltbclient/VoiceRoom;", "component1", "component2", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "", "other", "hashCode", "", "toString", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoiceRoomWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String forumName;
    public final VoiceRoom voiceRoom;

    public static /* synthetic */ VoiceRoomWrapper copy$default(VoiceRoomWrapper voiceRoomWrapper, VoiceRoom voiceRoom, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            voiceRoom = voiceRoomWrapper.voiceRoom;
        }
        if ((i & 2) != 0) {
            str = voiceRoomWrapper.forumName;
        }
        return voiceRoomWrapper.copy(voiceRoom, str);
    }

    public final VoiceRoom component1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.voiceRoom : (VoiceRoom) invokeV.objValue;
    }

    public final String component2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public final VoiceRoomWrapper copy(VoiceRoom voiceRoom, String forumName) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceRoom, forumName)) == null) {
            Intrinsics.checkNotNullParameter(voiceRoom, "voiceRoom");
            Intrinsics.checkNotNullParameter(forumName, "forumName");
            return new VoiceRoomWrapper(voiceRoom, forumName);
        }
        return (VoiceRoomWrapper) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VoiceRoomWrapper) {
                VoiceRoomWrapper voiceRoomWrapper = (VoiceRoomWrapper) obj;
                return Intrinsics.areEqual(this.voiceRoom, voiceRoomWrapper.voiceRoom) && Intrinsics.areEqual(this.forumName, voiceRoomWrapper.forumName);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (this.voiceRoom.hashCode() * 31) + this.forumName.hashCode() : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "VoiceRoomWrapper(voiceRoom=" + this.voiceRoom + ", forumName=" + this.forumName + ')';
        }
        return (String) invokeV.objValue;
    }

    public VoiceRoomWrapper(VoiceRoom voiceRoom, String forumName) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {voiceRoom, forumName};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(voiceRoom, "voiceRoom");
        Intrinsics.checkNotNullParameter(forumName, "forumName");
        this.voiceRoom = voiceRoom;
        this.forumName = forumName;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.forumName;
        }
        return (String) invokeV.objValue;
    }

    public final VoiceRoom getVoiceRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.voiceRoom;
        }
        return (VoiceRoom) invokeV.objValue;
    }
}
