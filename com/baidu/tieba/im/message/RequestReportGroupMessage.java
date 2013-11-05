package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestReportGroupMessage extends Message {
    private static final long serialVersionUID = 5970126981799423191L;
    private int mGroupId;
    private int mReportType;

    public RequestReportGroupMessage() {
        setCmd(103103);
    }

    public int getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(int i) {
        this.mGroupId = i;
    }

    public int getReportType() {
        return this.mReportType;
    }

    public void setReportType(int i) {
        this.mReportType = i;
    }
}
