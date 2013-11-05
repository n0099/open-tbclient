package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class SaveDraftMessage extends Message {
    private String mDraft;
    private String mGroupId;

    public SaveDraftMessage() {
        setCmd(-104);
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public String getDraft() {
        return this.mDraft;
    }

    public void setDraft(String str) {
        this.mDraft = str;
    }
}
