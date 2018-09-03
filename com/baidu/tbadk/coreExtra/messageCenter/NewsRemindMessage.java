package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aDR = false;
        private int aEm = 0;
        private int aEn = 0;
        private int aEo = 0;
        private int aEp = 0;
        private boolean aDT = false;
        private int aEq = 0;
        private boolean aEr = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a();
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.aDR;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aDR = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aEm;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aEm = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aEn;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aEn = i;
    }

    public int getMsgAtCount() {
        return this.mData.aEo;
    }

    public void setMsgAtCount(int i) {
        this.mData.aEo = i;
    }

    public int getChatCount() {
        return this.mData.aEp;
    }

    public void setChatCount(int i) {
        this.mData.aEp = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aDT;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aDT = z;
    }

    public int getNotificationCount() {
        return this.mData.aEq;
    }

    public void setNotificationCount(int i) {
        this.mData.aEq = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aEr;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aEr = z;
    }
}
