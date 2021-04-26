package com.baidu.tieba.barselect.model;

import com.baidu.tbadk.message.websockt.TbSocketReponsedMessage;
import com.squareup.wire.Wire;
import d.a.j0.v.b.a;
import tbclient.Error;
import tbclient.Search.SearchResIdl;
/* loaded from: classes4.dex */
public class CandidateSearchSocketResMsg extends TbSocketReponsedMessage {
    public a candidateData;

    public CandidateSearchSocketResMsg() {
        super(309641);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.message.websockt.TbSocketReponsedMessage, com.baidu.adp.framework.message.SocketResponsedMessage, com.baidu.adp.framework.message.ResponsedMessage
    public void decodeInBackGround(int i2, byte[] bArr) throws Exception {
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
            this.candidateData.f61553a = ((CandidateSearchReqMsg) getOrginalMessage().getExtra()).fid;
        }
    }
}
