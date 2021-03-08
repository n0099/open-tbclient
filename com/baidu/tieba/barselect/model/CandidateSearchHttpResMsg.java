package com.baidu.tieba.barselect.model;

import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.message.http.TbHttpResponsedMessage;
import com.squareup.wire.Wire;
import tbclient.Search.SearchResIdl;
/* loaded from: classes7.dex */
public class CandidateSearchHttpResMsg extends TbHttpResponsedMessage {
    public com.baidu.tieba.barselect.data.a candidateData;

    public CandidateSearchHttpResMsg() {
        super(CmdConfigHttp.CMD_CANDIDATE_SEARCH);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.http.TbHttpResponsedMessage, com.baidu.adp.framework.message.a
    public void decodeInBackGround(int i, byte[] bArr) throws Exception {
        super.decodeInBackGround(i, bArr);
        SearchResIdl searchResIdl = (SearchResIdl) new Wire(new Class[0]).parseFrom(bArr, SearchResIdl.class);
        if (searchResIdl != null && searchResIdl.data != null) {
            if (searchResIdl.error != null) {
                setError(searchResIdl.error.errorno.intValue());
                setErrorString(searchResIdl.error.errmsg);
            }
            if (searchResIdl.data.uid.longValue() != 0) {
                this.candidateData = new com.baidu.tieba.barselect.data.a();
                this.candidateData.a(searchResIdl.data);
                if (getOrginalMessage() != null && (getOrginalMessage().getExtra() instanceof CandidateSearchReqMsg)) {
                    this.candidateData.forumId = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
                }
            }
        }
    }
}
