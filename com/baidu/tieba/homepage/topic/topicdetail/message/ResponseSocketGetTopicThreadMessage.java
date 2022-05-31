package com.baidu.tieba.homepage.topic.topicdetail.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.jn;
import com.repackage.jz6;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.DataRes;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes3.dex */
public class ResponseSocketGetTopicThreadMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<jn> mDataList;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicThreadMessage() {
        super(309631);
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
        this.hasMore = false;
    }

    public List<jn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mDataList : (List) invokeV.objValue;
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.hasMore : invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        NewTopicThreadResIdl newTopicThreadResIdl;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (newTopicThreadResIdl = (NewTopicThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicThreadResIdl.class)) == null) {
            return;
        }
        setError(newTopicThreadResIdl.error.errorno.intValue());
        setErrorString(newTopicThreadResIdl.error.usermsg);
        if (getError() != 0 || (dataRes = newTopicThreadResIdl.data) == null || ListUtils.isEmpty(dataRes.thread_list)) {
            return;
        }
        if (newTopicThreadResIdl.data.has_more.intValue() == 1) {
            this.hasMore = true;
        }
        this.mDataList = new ArrayList();
        for (TopicThread topicThread : newTopicThreadResIdl.data.thread_list) {
            if (topicThread != null) {
                jz6 jz6Var = new jz6();
                jz6Var.g(topicThread);
                this.mDataList.add(jz6Var);
            }
        }
    }
}
