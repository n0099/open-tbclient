package com.baidu.tieba.homepage.topic.topicdetail.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.hn;
import com.baidu.tieba.ou7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.ArrayList;
import java.util.List;
import tbclient.NewTopicThread.DataRes;
import tbclient.NewTopicThread.NewTopicThreadResIdl;
import tbclient.NewTopicThread.TopicThread;
/* loaded from: classes4.dex */
public class ResponseSocketGetTopicThreadMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean hasMore;
    public List<hn> mDataList;

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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        DataRes dataRes;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            NewTopicThreadResIdl newTopicThreadResIdl = (NewTopicThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, NewTopicThreadResIdl.class);
            if (newTopicThreadResIdl == null) {
                return null;
            }
            setError(newTopicThreadResIdl.error.errorno.intValue());
            setErrorString(newTopicThreadResIdl.error.usermsg);
            if (getError() == 0 && (dataRes = newTopicThreadResIdl.data) != null && !ListUtils.isEmpty(dataRes.thread_list)) {
                if (newTopicThreadResIdl.data.has_more.intValue() == 1) {
                    this.hasMore = true;
                }
                this.mDataList = new ArrayList();
                for (TopicThread topicThread : newTopicThreadResIdl.data.thread_list) {
                    if (topicThread != null) {
                        ou7 ou7Var = new ou7();
                        ou7Var.d(topicThread);
                        this.mDataList.add(ou7Var);
                    }
                }
            }
            return newTopicThreadResIdl;
        }
        return invokeIL.objValue;
    }

    public List<hn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDataList;
        }
        return (List) invokeV.objValue;
    }

    public boolean getHasMore() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.hasMore;
        }
        return invokeV.booleanValue;
    }
}
