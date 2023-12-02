package com.baidu.tieba.barselect.model;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.baidu.tieba.ze6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Search.SearchResIdl;
/* loaded from: classes5.dex */
public class CandidateSearchHttpResMsg extends TbHttpResponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ze6 candidateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateSearchHttpResMsg() {
        super(CmdConfigHttp.CMD_CANDIDATE_SEARCH);
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, bArr) == null) {
            super.decodeInBackGround(i, bArr);
            SearchResIdl searchResIdl = (SearchResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchResIdl.class);
            if (searchResIdl != null && searchResIdl.data != null) {
                Error error = searchResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(searchResIdl.error.errmsg);
                }
                if (searchResIdl.data.uid.longValue() != 0) {
                    ze6 ze6Var = new ze6();
                    this.candidateData = ze6Var;
                    ze6Var.a(searchResIdl.data);
                    if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CandidateSearchReqMsg)) {
                        this.candidateData.a = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
                    }
                }
            }
        }
    }
}
