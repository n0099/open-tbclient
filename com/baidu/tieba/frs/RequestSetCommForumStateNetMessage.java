package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import tbclient.SetCommonForumState.DataReq;
import tbclient.SetCommonForumState.SetCommonForumStateReqIdl;
/* loaded from: classes6.dex */
public class RequestSetCommForumStateNetMessage extends NetMessage {
    private long mForumId;
    private int operation;

    public void setForumId(long j) {
        this.mForumId = j;
    }

    public void setOperation(int i) {
        this.operation = i;
    }

    public RequestSetCommForumStateNetMessage() {
        super(1003151, CmdConfigSocket.SET_COMMON_FORUM_STATE);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.forum_id = Long.valueOf(this.mForumId);
        builder.operation = Integer.valueOf(this.operation);
        if (z) {
            com.baidu.tbadk.util.t.a(builder, true);
        }
        SetCommonForumStateReqIdl.Builder builder2 = new SetCommonForumStateReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
