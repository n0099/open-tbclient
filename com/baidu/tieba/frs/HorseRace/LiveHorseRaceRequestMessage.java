package com.baidu.tieba.frs.HorseRace;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tbadk.util.NetMessageHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.CommonReq;
import tbclient.GetHorseRaceLampList.DataReq;
import tbclient.GetHorseRaceLampList.GetHorseRaceLampListReqIdl;
/* loaded from: classes5.dex */
public class LiveHorseRaceRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: common  reason: collision with root package name */
    public CommonReq f1096common;
    public Long forum_id;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveHorseRaceRequestMessage() {
        super(CmdConfigHttp.CMD_FRS_LIVE_HORSE_RACE_LIST, 309667);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            DataReq.Builder builder = new DataReq.Builder();
            builder.f1342common = this.f1096common;
            builder.forum_id = this.forum_id;
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                NetMessageHelper.bindCommonParamsToProtobufData(builder, true);
            }
            GetHorseRaceLampListReqIdl.Builder builder2 = new GetHorseRaceLampListReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public void setCommon(CommonReq commonReq) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, commonReq) == null) {
            this.f1096common = commonReq;
        }
    }

    public void setForum_id(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l) == null) {
            this.forum_id = l;
        }
    }
}
