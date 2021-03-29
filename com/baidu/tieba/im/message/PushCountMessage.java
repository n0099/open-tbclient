package com.baidu.tieba.im.message;

import com.baidu.tbadk.message.websockt.TbSocketMessage;
import protobuf.CommitPusherCount.CommitPusherCountReqIdl;
import protobuf.CommitPusherCount.DataReq;
/* loaded from: classes3.dex */
public class PushCountMessage extends TbSocketMessage {
    public long downFlowSize;
    public int enterForeCount;
    public int pusherCount;
    public long upFlowSize;

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

    public long getDownFlowSize() {
        return this.downFlowSize;
    }

    public int getEnterForeCount() {
        return this.enterForeCount;
    }

    public long getPusherCount() {
        return this.pusherCount;
    }

    public long getUpFlowSize() {
        return this.upFlowSize;
    }

    public void setDownFlowSize(long j) {
        this.downFlowSize = j;
    }

    public void setEnterForeCount(int i) {
        this.enterForeCount = i;
    }

    public void setPusherCount(int i) {
        this.pusherCount = i;
    }

    public void setUpFlowSize(long j) {
        this.upFlowSize = j;
    }
}
