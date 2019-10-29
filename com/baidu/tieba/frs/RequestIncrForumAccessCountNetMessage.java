package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import tbclient.IncrForumAccessCount.DataReq;
import tbclient.IncrForumAccessCount.IncrForumAccessCountReqIdl;
/* loaded from: classes4.dex */
public class RequestIncrForumAccessCountNetMessage extends NetMessage {
    private long mForumId;

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public RequestIncrForumAccessCountNetMessage() {
        super(1003150, CmdConfigSocket.INCREASE_FORUM_ACCESS_COUNT);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        if (z) {
            com.baidu.tbadk.util.r.a(builder, true);
        }
        IncrForumAccessCountReqIdl.Builder builder2 = new IncrForumAccessCountReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
