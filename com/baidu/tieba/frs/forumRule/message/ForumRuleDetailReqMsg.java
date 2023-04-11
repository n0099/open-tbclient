package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.switchs.SocketAddCommonParamSwitch;
import com.baidu.tieba.qq5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ForumRuleDetail.DataReq;
import tbclient.ForumRuleDetail.ForumRuleDetailReqIdl;
/* loaded from: classes4.dex */
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

    private Long getForumRuleId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.mForumRuleId;
        }
        return (Long) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            try {
                DataReq.Builder builder = new DataReq.Builder();
                builder.forum_id = getForumRuleId();
                if (z || SocketAddCommonParamSwitch.getIsOn()) {
                    qq5.c(builder, true, true, false);
                }
                ForumRuleDetailReqIdl.Builder builder2 = new ForumRuleDetailReqIdl.Builder();
                builder2.data = builder.build(false);
                return builder2.build(false);
            } catch (Exception e) {
                e.printStackTrace();
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
