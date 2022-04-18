package com.baidu.tieba.enterForum.recommend.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.g66;
import com.squareup.wire.Wire;
import tbclient.Recommforum.RecommforumResIdl;
/* loaded from: classes3.dex */
public class ResponseHttpRecommendMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g66 mRecommendData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpRecommendMessage() {
        super(CmdConfigHttp.CMD_RECOMMEND_FORUM);
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

    public g66 getRecommendData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mRecommendData : (g66) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        RecommforumResIdl recommforumResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (recommforumResIdl = (RecommforumResIdl) new Wire(new Class[0]).parseFrom(bArr, RecommforumResIdl.class)) == null) {
            return;
        }
        setError(recommforumResIdl.error.errorno.intValue());
        setErrorString(recommforumResIdl.error.usermsg);
        if (getError() != 0 || recommforumResIdl.data == null) {
            return;
        }
        g66 g66Var = new g66();
        this.mRecommendData = g66Var;
        g66Var.h(recommforumResIdl.data);
    }
}
