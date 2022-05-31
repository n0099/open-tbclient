package com.baidu.tieba.enterForum.hotuserrank.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dc5;
import tbclient.GetInfluenceRank.DataReq;
import tbclient.GetInfluenceRank.GetInfluenceRankReqIdl;
/* loaded from: classes3.dex */
public class HotUserRankReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String category;
    public long forumId;
    public int pageNum;
    public int pageSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HotUserRankReqMsg() {
        super(CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
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
            if (z || SocketAddCommonParamSwitch.getIsOn()) {
                dc5.a(builder, true);
            }
            builder.tieba_name = this.category;
            builder.forum_id = Long.valueOf(this.forumId);
            builder.rn = Integer.valueOf(this.pageSize);
            builder.pn = Integer.valueOf(this.pageNum);
            GetInfluenceRankReqIdl.Builder builder2 = new GetInfluenceRankReqIdl.Builder();
            builder2.data = builder.build(false);
            return builder2.build(false);
        }
        return invokeZ.objValue;
    }
}
