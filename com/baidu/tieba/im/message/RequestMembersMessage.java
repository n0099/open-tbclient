package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestMembersMessage extends Message {
    private static final long serialVersionUID = -8719158846923061689L;
    private long groupId;
    private int offset;
    private int orderType;
    private int rn;

    public RequestMembersMessage() {
        setCmd(103005);
    }

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int i) {
        this.offset = i;
    }

    public int getRn() {
        return this.rn;
    }

    public void setRn(int i) {
        this.rn = i;
    }

    public int getOrderType() {
        return this.orderType;
    }

    public void setOrderType(int i) {
        this.orderType = i;
    }
}
