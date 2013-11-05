package com.baidu.tieba.im.message;

import java.util.List;
/* loaded from: classes.dex */
public class LoadHistoryResponsedMessage extends ResponsedMessage {
    private String groupId;
    private boolean isFirst;
    private List<ChatMessage> msgList;

    public LoadHistoryResponsedMessage() {
        setCmd(-105);
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public List<ChatMessage> getMsgList() {
        return this.msgList;
    }

    public void setMsgList(List<ChatMessage> list) {
        this.msgList = list;
    }

    public boolean getIsFirst() {
        return this.isFirst;
    }

    public void setIsFirst(boolean z) {
        this.isFirst = z;
    }
}
