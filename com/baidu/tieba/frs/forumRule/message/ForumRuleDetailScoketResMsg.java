package com.baidu.tieba.frs.forumRule.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.q0.u0.p1.c.b;
import tbclient.Error;
import tbclient.ForumRuleDetail.ForumRuleDetailResIdl;
/* loaded from: classes4.dex */
public class ForumRuleDetailScoketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b mForumRuleDetailData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailScoketResMsg() {
        super(309690);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public b getmForumRuleDetailData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mForumRuleDetailData : (b) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        ForumRuleDetailResIdl forumRuleDetailResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || bArr == null || (forumRuleDetailResIdl = (ForumRuleDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRuleDetailResIdl.class)) == null) {
            return;
        }
        Error error = forumRuleDetailResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(forumRuleDetailResIdl.error.usermsg);
        }
        if (forumRuleDetailResIdl.data != null) {
            b bVar = new b();
            this.mForumRuleDetailData = bVar;
            bVar.q(forumRuleDetailResIdl.data);
        }
    }
}
