package com.baidu.tieba.barselect.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import d.b.i0.v.b.a;
import tbclient.Error;
import tbclient.Search.SearchResIdl;
/* loaded from: classes4.dex */
public class CandidateSearchHttpResMsg extends TbHttpResponsedMessage {
    public a candidateData;

    public CandidateSearchHttpResMsg() {
        super(CmdConfigHttp.CMD_CANDIDATE_SEARCH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.HttpResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        SearchResIdl searchResIdl = (SearchResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchResIdl.class);
        if (searchResIdl == null || searchResIdl.data == null) {
            return;
        }
        Error error = searchResIdl.error;
        if (error != null) {
            setError(error.errorno.intValue());
            setErrorString(searchResIdl.error.errmsg);
        }
        if (searchResIdl.data.uid.longValue() != 0) {
            a aVar = new a();
            this.candidateData = aVar;
            aVar.a(searchResIdl.data);
            if (getOrginalMessage() == null || !(getOrginalMessage().getExtra() instanceof CandidateSearchReqMsg)) {
                return;
            }
            this.candidateData.f61896a = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
        }
    }
}
