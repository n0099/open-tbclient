package com.baidu.tieba.forumsearch.message;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.vg6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.SearchPostForum.SearchPostForumResIdl;
/* loaded from: classes4.dex */
public class SearchPostForumSocketResponseMessage extends SocketResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public vg6 mSearchData;

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

    public vg6 getSearchData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mSearchData;
        }
        return (vg6) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            SearchPostForumResIdl searchPostForumResIdl = (SearchPostForumResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchPostForumResIdl.class);
            if (searchPostForumResIdl != null) {
                Error error = searchPostForumResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(searchPostForumResIdl.error.usermsg);
                }
                if (getError() == 0 && getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof SearchPostForumRequestMessage) && searchPostForumResIdl.data != null) {
                    vg6 vg6Var = new vg6(((SearchPostForumRequestMessage) getOrginalMessage().getExtra()).get_word());
                    this.mSearchData = vg6Var;
                    vg6Var.b(searchPostForumResIdl.data);
                }
            }
            return searchPostForumResIdl;
        }
        return invokeIL.objValue;
    }
}
