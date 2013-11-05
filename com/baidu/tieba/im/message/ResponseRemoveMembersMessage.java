package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ResponseRemoveMembersMessage extends ResponsedMessage {
    private static final long serialVersionUID = 7867292299610619970L;
    private String groupId;

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public ResponseRemoveMembersMessage() {
    }

    public ResponseRemoveMembersMessage(int i) {
        super(i);
    }
}
