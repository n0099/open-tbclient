package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class PushCountMessage extends Message {
    private static final long serialVersionUID = -4476585135528193926L;
    private long downFlowSize;
    private int pusherCount;
    private long upFlowSize;

    public int getPusherCount() {
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
        setCmd(202101);
    }
}
