package com.baidu.tieba.hottopic.message;

import c.a.r0.p1.l.d;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes10.dex */
public class ResponseSocketGetTopicRelateThreadMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d hotThreadItemListData;
    public Page page;
    public List<ThreadInfo> thread_list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicRelateThreadMessage() {
        super(309005);
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

    public d getHotThreadItemListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hotThreadItemListData : (d) invokeV.objValue;
    }

    public Page getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.page : (Page) invokeV.objValue;
    }

    public List<ThreadInfo> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.thread_list : (List) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        GetTopicRelateThreadResIdl getTopicRelateThreadResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class)) == null) {
            return;
        }
        setError(getTopicRelateThreadResIdl.error.errorno.intValue());
        setErrorString(getTopicRelateThreadResIdl.error.usermsg);
        if (getError() != 0) {
            return;
        }
        DataRes dataRes = getTopicRelateThreadResIdl.data;
        this.thread_list = dataRes.thread_list;
        this.page = dataRes.page;
        d dVar = new d();
        this.hotThreadItemListData = dVar;
        dVar.Y4(getTopicRelateThreadResIdl.data);
    }
}
