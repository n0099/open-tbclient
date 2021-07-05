package com.baidu.tieba.hottopic.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import d.a.s0.g1.c.j;
import tbclient.TopicList.TopicListResIdl;
/* loaded from: classes5.dex */
public class ResponseSocketHotRanklistMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j ranklistData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketHotRanklistMessage() {
        super(309289);
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

    public j getHotRanklistData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.ranklistData : (j) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i2, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) {
            super.afterDispatchInBackGround(i2, (int) bArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        TopicListResIdl topicListResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(1048579, this, i2, bArr) == null) || (topicListResIdl = (TopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, TopicListResIdl.class)) == null) {
            return;
        }
        setError(topicListResIdl.error.errorno.intValue());
        setErrorString(topicListResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        j jVar = new j();
        this.ranklistData = jVar;
        jVar.c(topicListResIdl.data);
    }
}
