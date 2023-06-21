package com.baidu.tieba.forumsearch.message;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.wc7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes5.dex */
public class SearchPostForumHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wc7 mSearchData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPostForumHttpResponseMessage(int i) {
        super(i);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchPostForumResIdl searchPostForumResIdl;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) && (searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class)) != null) {
            Error error = searchPostForumResIdl.error;
            if (error != null) {
                setError(error.errorno.intValue());
                setErrorString(searchPostForumResIdl.error.usermsg);
            }
            if (getError() == 0 && getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof SearchPostForumRequestMessage) && searchPostForumResIdl.data != null) {
                wc7 wc7Var = new wc7(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
                this.mSearchData = wc7Var;
                wc7Var.b(searchPostForumResIdl.data);
            }
        }
    }

    public wc7 getSearchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mSearchData;
        }
        return (wc7) invokeV.objValue;
    }
}
