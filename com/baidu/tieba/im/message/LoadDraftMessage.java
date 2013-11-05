package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class LoadDraftMessage extends Message {
    private String groupId;

    public LoadDraftMessage() {
        setCmd(-103);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
