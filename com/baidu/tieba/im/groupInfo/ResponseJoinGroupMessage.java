package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class ResponseJoinGroupMessage extends ResponsedMessage {
    private static final long serialVersionUID = 5970126981799423191L;
    private String content;
    private String groupId;
    private String userMsg;

    public ResponseJoinGroupMessage() {
        setCmd(103110);
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public String getUserMsg() {
        return this.userMsg;
    }

    public void setUserMsg(String str) {
        this.userMsg = str;
    }
}
