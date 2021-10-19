package com.baidu.tieba.frs.forumRule.message;

import c.a.q0.d1.z;
import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumRuleDetail.DataReq;
import tbclient.ForumRuleDetail.ForumRuleDetailReqIdl;
/* loaded from: classes7.dex */
public class ForumRuleDetailReqMsg extends NetMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long mForumRuleId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailReqMsg() {
        super(CmdConfigHttp.CMD_FORUM_RULES_SHOW, 309690);
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

    private Long getForumRuleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? this.mForumRuleId : (Long) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.forum_id = getForumRuleId();
                if (z) {
                    z.c(builder, true, true, false);
                }
                ForumRuleDetailReqIdl.Builder builder2 = new ForumRuleDetailReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return invokeZ.objValue;
    }

    public void setForumRuleId(Long l) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l) == null) {
            this.mForumRuleId = l;
        }
    }
}
