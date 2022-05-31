package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.qa6;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes3.dex */
public class SearchPostForumSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qa6 mSearchData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchPostForumSocketResponseMessage() {
        super(309466);
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

    public qa6 getSearchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSearchData : (qa6) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        SearchPostForumResIdl searchPostForumResIdl;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) || (searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class)) == null) {
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
        qa6 qa6Var = new qa6(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
        this.mSearchData = qa6Var;
        qa6Var.b(searchPostForumResIdl.data);
    }
}
