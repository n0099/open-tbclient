package com.baidu.tieba.im.groupInfo;

import com.baidu.tieba.im.message.Message;
/* loaded from: classes.dex */
public class RequestJoinGroupMessage extends Message {
    private static final long serialVersionUID = 3361582238615671694L;
    private String groupId;
    private String userMsg;

    public RequestJoinGroupMessage() {
        setCmd(103110);
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
