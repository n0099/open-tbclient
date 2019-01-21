package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aQw = false;
        private int aQR = 0;
        private int aQS = 0;
        private int aQT = 0;
        private int aQU = 0;
        private boolean aQy = false;
        private int aQV = 0;
        private boolean aQW = false;

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
        return this.mData.aQw;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aQw = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aQR;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aQR = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aQS;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aQS = i;
    }

    public int getMsgAtCount() {
        return this.mData.aQT;
    }

    public void setMsgAtCount(int i) {
        this.mData.aQT = i;
    }

    public int getChatCount() {
        return this.mData.aQU;
    }

    public void setChatCount(int i) {
        this.mData.aQU = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aQy;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aQy = z;
    }

    public int getNotificationCount() {
        return this.mData.aQV;
    }

    public void setNotificationCount(int i) {
        this.mData.aQV = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aQW;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aQW = z;
    }
}
