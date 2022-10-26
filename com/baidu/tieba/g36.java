package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.VoiceRoom;
/* loaded from: classes4.dex */
public class g36 extends e36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String N0;
    public List O0;
    public String P0;
    public String Q0;
    public long R0;

    public g36(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {threadData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (threadData == null) {
            return;
        }
        this.a = threadData;
        String str = threadData.tid;
        threadData.getTitle();
        VoiceRoom voiceRoomData = threadData.getVoiceRoomData();
        if (voiceRoomData != null) {
            this.N0 = voiceRoomData.room_name;
            this.O0 = e0(voiceRoomData);
            this.P0 = String.valueOf(voiceRoomData.talker_num);
            this.Q0 = String.valueOf(voiceRoomData.joined_num);
            this.R0 = voiceRoomData.room_id.longValue();
        }
    }

    public static boolean W(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, threadData)) == null) {
            if (threadData != null && threadData.getVoiceRoomData() != null && threadData.getVoiceRoomData().room_id.longValue() > 0 && !StringUtils.isNull(threadData.getVoiceRoomData().room_name)) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final List e0(VoiceRoom voiceRoom) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, voiceRoom)) == null) {
            ArrayList arrayList = new ArrayList();
            for (User user : voiceRoom.talker) {
                if (user != null) {
                    arrayList.add(user.portrait);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public List a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.O0;
        }
        return (List) invokeV.objValue;
    }

    public long b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.R0;
        }
        return invokeV.longValue;
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.N0;
        }
        return (String) invokeV.objValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.e36, com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.eo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (!this.B) {
                return e36.F0;
            }
            return ThreadData.TYPE_CONTENT_VOICE_ROOM;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
