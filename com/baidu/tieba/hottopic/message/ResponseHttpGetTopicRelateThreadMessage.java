package com.baidu.tieba.hottopic.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b37;
import com.squareup.wire.Wire;
import java.util.List;
import tbclient.GetTopicRelateThread.DataRes;
import tbclient.GetTopicRelateThread.GetTopicRelateThreadResIdl;
import tbclient.Page;
import tbclient.ThreadInfo;
/* loaded from: classes3.dex */
public class ResponseHttpGetTopicRelateThreadMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b37 hotThreadItemListData;
    public Page page;
    public List<ThreadInfo> thread_list;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResponseHttpGetTopicRelateThreadMessage(int i) {
        super(CmdConfigHttp.CMD_TOPIC_RELATE_THREAD);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
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

    public b37 getHotThreadItemListData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.hotThreadItemListData : (b37) invokeV.objValue;
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
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        GetTopicRelateThreadResIdl getTopicRelateThreadResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (getTopicRelateThreadResIdl = (GetTopicRelateThreadResIdl) new Wire(new Class[0]).parseFrom(bArr, GetTopicRelateThreadResIdl.class)) == null) {
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
        b37 b37Var = new b37();
        this.hotThreadItemListData = b37Var;
        b37Var.m(getTopicRelateThreadResIdl.data);
    }
}
