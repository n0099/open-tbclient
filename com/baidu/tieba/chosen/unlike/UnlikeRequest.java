package com.baidu.tieba.chosen.unlike;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.util.j;
import tbclient.Unlike.DataReq;
import tbclient.Unlike.UnlikeReqIdl;
/* loaded from: classes.dex */
public class UnlikeRequest extends NetMessage {
    private long threadId;
    private int type;

    public UnlikeRequest() {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public void setType(int i) {
        this.type = i;
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    protected Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_id = Long.valueOf(this.threadId);
        builder.type = Integer.valueOf(this.type);
        j.a(builder, true);
        UnlikeReqIdl.Builder builder2 = new UnlikeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
