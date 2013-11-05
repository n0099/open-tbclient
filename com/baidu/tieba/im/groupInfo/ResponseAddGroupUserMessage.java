package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class ResponseAddGroupUserMessage extends ResponsedMessage {
    private static final long serialVersionUID = -8765819395629830900L;
    private String content;
    private String groupId;

    public ResponseAddGroupUserMessage() {
        setCmd(103111);
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
}
