package com.baidu.tieba.im.forum.broadcast.data;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.qu8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.GetForumBroadcastList.GetForumBroadcastListResIdl;
/* loaded from: classes6.dex */
public class ResponseHttpMajorHistoryMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qu8 majorHistoryData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpMajorHistoryMessage() {
        super(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
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
        this.majorHistoryData = new qu8();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetForumBroadcastListResIdl getForumBroadcastListResIdl;
        Error error;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.decodeInBackGround(i, bArr);
            if (bArr == null || (error = (getForumBroadcastListResIdl = (GetForumBroadcastListResIdl) new Wire(new Class[0]).parseFrom(bArr, GetForumBroadcastListResIdl.class)).error) == null) {
                return;
            }
            setError(error.errorno.intValue());
            setErrorString(getForumBroadcastListResIdl.error.usermsg);
            if (getError() != 0) {
                return;
            }
            this.majorHistoryData.d(getForumBroadcastListResIdl.data);
            this.majorHistoryData.f();
        }
    }

    public qu8 getData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.majorHistoryData;
        }
        return (qu8) invokeV.objValue;
    }
}
