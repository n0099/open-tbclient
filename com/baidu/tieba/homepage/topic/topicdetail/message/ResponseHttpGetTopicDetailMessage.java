package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.a57;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.NewHottopic.NewHottopicResIdl;
/* loaded from: classes4.dex */
public class ResponseHttpGetTopicDetailMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a57 mTopicDetailData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpGetTopicDetailMessage() {
        super(CmdConfigHttp.CMD_TOPIC_DETAIL);
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

    public a57 getTopicDetailData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mTopicDetailData : (a57) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewHottopicResIdl newHottopicResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (newHottopicResIdl = (NewHottopicResIdl) new Wire(new Class[0]).parseFrom(bArr, NewHottopicResIdl.class)) == null) {
            return;
        }
        setError(newHottopicResIdl.error.errorno.intValue());
        setErrorString(newHottopicResIdl.error.usermsg);
        if (getError() != 0 || newHottopicResIdl.data == null) {
            return;
        }
        a57 a57Var = new a57();
        this.mTopicDetailData = a57Var;
        a57Var.b(newHottopicResIdl.data);
    }
}
