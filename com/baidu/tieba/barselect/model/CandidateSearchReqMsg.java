package com.baidu.tieba.barselect.model;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.t;
import tbclient.Search.DataReq;
import tbclient.Search.SearchReqIdl;
/* loaded from: classes8.dex */
public class CandidateSearchReqMsg extends NetMessage {
    public int applyId;
    public long fid;

    public CandidateSearchReqMsg() {
        super(CmdConfigHttp.CMD_CANDIDATE_SEARCH, 309641);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.apply_id = Integer.valueOf(this.applyId);
        builder.fid = Long.valueOf(this.fid);
        if (z) {
            t.b(builder, true);
        }
        SearchReqIdl.Builder builder2 = new SearchReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
