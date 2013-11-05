package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class RequestUserPermissionMessage extends Message {
    private static final long serialVersionUID = 7098001141426592665L;
    private long forumId;

    public RequestUserPermissionMessage() {
        setCmd(103008);
    }

    public long getForumId() {
        return this.forumId;
    }

    public void setForumId(long j) {
        this.forumId = j;
    }
}
