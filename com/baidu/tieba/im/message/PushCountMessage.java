package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CommitPusherCount.CommitPusherCountReqIdl;
import protobuf.CommitPusherCount.DataReq;
/* loaded from: classes.dex */
public class PushCountMessage extends TbSocketMessage {
    private long downFlowSize;
    private int enterForeCount;
    private int pusherCount;
    private long upFlowSize;

    public int getEnterForeCount() {
        return this.enterForeCount;
    }

    public void setEnterForeCount(int i) {
        this.enterForeCount = i;
    }

    public long getPusherCount() {
        return this.pusherCount;
    }

    public void setPusherCount(int i) {
        this.pusherCount = i;
    }

    public long getUpFlowSize() {
        return this.upFlowSize;
    }

    public void setUpFlowSize(long j) {
        this.upFlowSize = j;
    }

    public long getDownFlowSize() {
        return this.downFlowSize;
    }

    public void setDownFlowSize(long j) {
        this.downFlowSize = j;
    }

    public PushCountMessage() {
        super(202101);
    }

    @Override // com.baidu.tbadk.message.websockt.TbSocketMessage
    public Object encode() {
        DataReq.Builder builder = new DataReq.Builder();
        builder.downFlowSize = Long.valueOf(getDownFlowSize());
        builder.pusherCount = Long.valueOf(getPusherCount());
        builder.upFlowSize = Long.valueOf(getUpFlowSize());
        CommitPusherCountReqIdl.Builder builder2 = new CommitPusherCountReqIdl.Builder();
        builder2.data = builder.build(false);
        return builder2.build(false);
    }
}
