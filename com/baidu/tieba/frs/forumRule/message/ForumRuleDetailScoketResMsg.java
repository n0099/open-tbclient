package com.baidu.tieba.frs.forumRule.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nk6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.ForumRuleDetail.ForumRuleDetailResIdl;
/* loaded from: classes3.dex */
public class ForumRuleDetailScoketResMsg extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public nk6 mForumRuleDetailData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumRuleDetailScoketResMsg() {
        super(309690);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            if (bArr == null) {
                return null;
            }
            ForumRuleDetailResIdl forumRuleDetailResIdl = (ForumRuleDetailResIdl) new Wire(new Class[0]).parseFrom(bArr, ForumRuleDetailResIdl.class);
            if (forumRuleDetailResIdl != null) {
                Error error = forumRuleDetailResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(forumRuleDetailResIdl.error.usermsg);
                }
                if (forumRuleDetailResIdl.data != null) {
                    nk6 nk6Var = new nk6();
                    this.mForumRuleDetailData = nk6Var;
                    nk6Var.q(forumRuleDetailResIdl.data);
                }
            }
            return forumRuleDetailResIdl;
        }
        return invokeIL.objValue;
    }

    public nk6 getmForumRuleDetailData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mForumRuleDetailData : (nk6) invokeV.objValue;
    }
}
