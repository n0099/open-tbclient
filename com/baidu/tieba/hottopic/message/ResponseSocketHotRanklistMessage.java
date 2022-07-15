package com.baidu.tieba.hottopic.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.h37;
import com.squareup.wire.Wire;
import tbclient.TopicList.TopicListResIdl;
/* loaded from: classes3.dex */
public class ResponseSocketHotRanklistMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h37 ranklistData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketHotRanklistMessage() {
        super(309289);
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
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, bArr)) == null) {
            TopicListResIdl topicListResIdl = (TopicListResIdl) new Wire(new Class[0]).parseFrom(bArr, TopicListResIdl.class);
            if (topicListResIdl != null) {
                setError(topicListResIdl.error.errorno.intValue());
                setErrorString(topicListResIdl.error.usermsg);
                if (getError() != 0) {
                    return topicListResIdl;
                }
                h37 h37Var = new h37();
                this.ranklistData = h37Var;
                h37Var.b(topicListResIdl.data);
            }
            return topicListResIdl;
        }
        return invokeIL.objValue;
    }

    public h37 getHotRanklistData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.ranklistData : (h37) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.ResponsedMessage
    public void afterDispatchInBackGround(int i, byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.afterDispatchInBackGround(i, (int) bArr);
        }
    }
}
