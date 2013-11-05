package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class LoadDraftResponsedMessage extends ResponsedMessage {
    private String groupId;
    private String mDraft;

    public LoadDraftResponsedMessage() {
        setCmd(-103);
    }

    public String getDraft() {
        return this.mDraft;
    }

    public void setDraft(String str) {
        this.mDraft = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
