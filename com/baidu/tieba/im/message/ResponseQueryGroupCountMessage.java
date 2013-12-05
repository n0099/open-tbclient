package com.baidu.tieba.im.message;
/* loaded from: classes.dex */
public class ResponseQueryGroupCountMessage extends ResponsedMessage {
    private int localGroupCount;
    private int userGroupCount;

    public ResponseQueryGroupCountMessage() {
    }

    public ResponseQueryGroupCountMessage(int i) {
        super(i);
    }

    public int getUserGroupCount() {
        return this.userGroupCount;
    }

    public void setUserGroupCount(int i) {
        this.userGroupCount = i;
    }

    public int getLocalGroupCount() {
        return this.localGroupCount;
    }

    public void setLocalGroupCount(int i) {
        this.localGroupCount = i;
    }
}
