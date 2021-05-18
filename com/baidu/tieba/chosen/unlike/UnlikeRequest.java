package com.baidu.tieba.chosen.unlike;

import com.baidu.adp.framework.message.NetMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.a.j0.z0.w;
import tbclient.Unlike.DataReq;
import tbclient.Unlike.UnlikeReqIdl;
/* loaded from: classes4.dex */
public class UnlikeRequest extends NetMessage {
    public long threadId;
    public int type;

    public UnlikeRequest() {
        super(CmdConfigHttp.CMD_HOT_THREAD_UNLIKE, 307007);
    }

    @Override // com.baidu.adp.framework.message.NetMessage
    public Object encode(boolean z) {
        DataReq.Builder builder = new DataReq.Builder();
        builder.thread_id = Long.valueOf(this.threadId);
        builder.type = Integer.valueOf(this.type);
        w.a(builder, true);
        UnlikeReqIdl.Builder builder2 = new UnlikeReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }

    public void setThreadId(long j) {
        this.threadId = j;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
