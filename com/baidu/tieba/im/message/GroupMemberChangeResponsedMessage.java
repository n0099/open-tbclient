package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class GroupMemberChangeResponsedMessage extends ResponsedMessage {
    private String groupId;

    public GroupMemberChangeResponsedMessage() {
        super.setCmd(-109);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
