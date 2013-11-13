package com.baidu.tieba.data.chat;

import java.io.Serializable;
/* loaded from: classes.dex */
public class ChatPostData implements Serializable {
    private static final long serialVersionUID = -7096608987896994585L;
    private String mContent = null;
    private String mFriendID = null;
    private String mUserID = null;
    private long mLastMsgID = 0;

    public void setConent(String str) {
        this.mContent = str;
    }

    public void setFriendID(String str) {
        this.mFriendID = str;
    }

    public void setUserID(String str) {
        this.mUserID = str;
    }

    public void setLastMsgID(long j) {
        this.mLastMsgID = j;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getFriendID() {
        return this.mFriendID;
    }

    public String getUserID() {
        return this.mUserID;
    }

    public long getLastMsgID() {
        return this.mLastMsgID;
    }
}
