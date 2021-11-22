package com.baidu.tieba.enterForum.hotuserrank.model;

import b.a.q0.c1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.GetInfluenceRank.DataReq;
import tbclient.GetInfluenceRank.GetInfluenceRankReqIdl;
/* loaded from: classes8.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            if (z) {
                z.a(builder, true);
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
