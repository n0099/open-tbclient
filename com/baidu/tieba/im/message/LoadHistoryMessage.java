package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class LoadHistoryMessage extends Message {
    private String groupId;
    private String lastMsgId;
    private String lastRid;
    private int limit;

    public LoadHistoryMessage() {
        setCmd(-105);
    }

    public String getLastRid() {
        return this.lastRid;
    }

    public void setLastRid(String str) {
        this.lastRid = str;
    }

    public String getLastMsgId() {
        return this.lastMsgId;
    }

    public void setLastMsgId(String str) {
        this.lastMsgId = str;
    }

    public int getLimit() {
        return this.limit;
    }

    public void setLimit(int i) {
        this.limit = i;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
