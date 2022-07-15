package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.td5;
import tbclient.GetBawuInfo.DataReq;
import tbclient.GetBawuInfo.GetBawuInfoReqIdl;
/* loaded from: classes3.dex */
public class BawuTeamRequestMessage extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BawuTeamRequestMessage() {
        super(CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007);
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
            builder.forum_id = Long.valueOf(this.forumId);
            GetBawuInfoReqIdl.Builder builder2 = new GetBawuInfoReqIdl.Builder();
            builder2.data = builder.build(false);
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                td5.a(builder, true);
            }
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }

    public long getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.forumId : invokeV.longValue;
    }

    public void setForumId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.forumId = j;
        }
    }
}
