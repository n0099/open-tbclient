package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ResponseDismissGroupMessage extends ResponsedMessage {
    private static final long serialVersionUID = 8229869551475099805L;
    private long groupId;

    public long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(long j) {
        this.groupId = j;
    }

    public ResponseDismissGroupMessage() {
    }

    public ResponseDismissGroupMessage(int i) {
        super(i);
    }
}
