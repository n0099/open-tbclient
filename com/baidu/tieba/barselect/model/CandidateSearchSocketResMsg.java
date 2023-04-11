package com.baidu.tieba.barselect.model;

import androidx.annotation.Nullable;
import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.baidu.tieba.qa6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Wire;
import tbclient.Error;
import tbclient.Search.SearchResIdl;
/* loaded from: classes3.dex */
public class CandidateSearchSocketResMsg extends TbSocketReponsedMessage {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qa6 candidateData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CandidateSearchSocketResMsg() {
        super(309641);
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

    @Override // com.baidu.adp.framework.message.SocketResponsedMessage
    @Nullable
    public Object decodeInBackGroundNeedResult(int i, byte[] bArr) throws Exception {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048576, this, i, bArr)) == null) {
            SearchResIdl searchResIdl = (SearchResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchResIdl.class);
            if (searchResIdl != null && searchResIdl.data != null) {
                Error error = searchResIdl.error;
                if (error != null) {
                    setError(error.errorno.intValue());
                    setErrorString(searchResIdl.error.errmsg);
                }
                if (searchResIdl.data.uid.longValue() != 0) {
                    qa6 qa6Var = new qa6();
                    this.candidateData = qa6Var;
                    qa6Var.a(searchResIdl.data);
                    if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CandidateSearchReqMsg)) {
                        this.candidateData.a = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
                    }
                }
            }
            return searchResIdl;
        }
        return invokeIL.objValue;
    }
}
