package com.baidu.tieba.forumsearch.message;

import c.a.q0.u0.c.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes7.dex */
public class SearchPostForumHttpResponseMessage extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c mSearchData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPostForumHttpResponseMessage(int i2) {
        super(i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public c getSearchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSearchData : (c) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
        SearchPostForumResIdl searchPostForumResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, bArr) == null) || (searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class)) == null) {
            return;
        }
        Error error = searchPostForumResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(searchPostForumResIdl.error.usermsg);
        }
        if (getError() != 0 || getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof SearchPostForumRequestMessage) || searchPostForumResIdl.data == null) {
            return;
        }
        c cVar = new c(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
        this.mSearchData = cVar;
        cVar.b(searchPostForumResIdl.data);
    }
}
