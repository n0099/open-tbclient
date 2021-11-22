package com.baidu.tieba.frs.voiceroom.data;

import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tbclient.VoiceRoom.VoiceRoom;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0087\b\u0018\u0000B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0001\u0012\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0002\u001a\u00020\u0001HÆ\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "Ltbclient/VoiceRoom/VoiceRoom;", "component1", "()Ltbclient/VoiceRoom/VoiceRoom;", "", "component2", "()Ljava/lang/String;", "voiceRoom", "forumName", "copy", "(Ltbclient/VoiceRoom/VoiceRoom;Ljava/lang/String;)Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", TTDownloadField.TT_HASHCODE, "()I", "toString", "Ljava/lang/String;", "getForumName", "Ltbclient/VoiceRoom/VoiceRoom;", "getVoiceRoom", "<init>", "(Ltbclient/VoiceRoom/VoiceRoom;Ljava/lang/String;)V", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VoiceRoomWrapper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String forumName;
    public final VoiceRoom voiceRoom;

    public VoiceRoomWrapper(VoiceRoom voiceRoom, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {voiceRoom, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.voiceRoom = voiceRoom;
        this.forumName = str;
    }

    public static /* synthetic */ VoiceRoomWrapper copy$default(VoiceRoomWrapper voiceRoomWrapper, VoiceRoom voiceRoom, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            voiceRoom = voiceRoomWrapper.voiceRoom;
        }
        if ((i2 & 2) != 0) {
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

    public final VoiceRoomWrapper copy(VoiceRoom voiceRoom, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, voiceRoom, str)) == null) ? new VoiceRoomWrapper(voiceRoom, str) : (VoiceRoomWrapper) invokeLL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            if (this != obj) {
                if (obj instanceof VoiceRoomWrapper) {
                    VoiceRoomWrapper voiceRoomWrapper = (VoiceRoomWrapper) obj;
                    return Intrinsics.areEqual(this.voiceRoom, voiceRoomWrapper.voiceRoom) && Intrinsics.areEqual(this.forumName, voiceRoomWrapper.forumName);
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final String getForumName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.forumName : (String) invokeV.objValue;
    }

    public final VoiceRoom getVoiceRoom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.voiceRoom : (VoiceRoom) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            VoiceRoom voiceRoom = this.voiceRoom;
            int hashCode = (voiceRoom != null ? voiceRoom.hashCode() : 0) * 31;
            String str = this.forumName;
            return hashCode + (str != null ? str.hashCode() : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "VoiceRoomWrapper(voiceRoom=" + this.voiceRoom + ", forumName=" + this.forumName + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
