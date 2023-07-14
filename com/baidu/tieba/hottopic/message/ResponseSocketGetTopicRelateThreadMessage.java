package com.baidu.tieba.hottopic.message;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.za8;
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
/* loaded from: classes6.dex */
public class ResponseSocketGetTopicRelateThreadMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public za8 hotThreadItemListData;
    public Page page;
    public List<ThreadInfo> thread_list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseSocketGetTopicRelateThreadMessage() {
        super(309005);
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

    public za8 getHotThreadItemListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.hotThreadItemListData;
        }
        return (za8) invokeV.objValue;
    }

    public Page getPage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.page;
        }
        return (Page) invokeV.objValue;
    }

    public List<ThreadInfo> getThreadList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.thread_list;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            GetTopicRelateThreadResIdl getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class);
            if (getTopicRelateThreadResIdl != null) {
                setError(getTopicRelateThreadResIdl.error.errorno.intValue());
                setErrorString(getTopicRelateThreadResIdl.error.usermsg);
                if (getError() != 0) {
                    return getTopicRelateThreadResIdl;
                }
                DataRes dataRes = getTopicRelateThreadResIdl.data;
                this.thread_list = dataRes.thread_list;
                this.page = dataRes.page;
                za8 za8Var = new za8();
                this.hotThreadItemListData = za8Var;
                za8Var.h(getTopicRelateThreadResIdl.data);
            }
            return getTopicRelateThreadResIdl;
        }
        return invokeIL.objValue;
    }
}
