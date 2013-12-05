package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class GroupDeleteMsgResponsedMessage extends ResponsedMessage {
    private String groupId;

    public GroupDeleteMsgResponsedMessage() {
        super.setCmd(-113);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
