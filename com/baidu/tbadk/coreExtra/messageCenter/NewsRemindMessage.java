package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aMq = false;
        private int aML = 0;
        private int aMM = 0;
        private int aMN = 0;
        private int aMO = 0;
        private boolean aMs = false;
        private int aMP = 0;
        private boolean aMQ = false;

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
        return this.mData.aMq;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aMq = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aML;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aML = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aMM;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aMM = i;
    }

    public int getMsgAtCount() {
        return this.mData.aMN;
    }

    public void setMsgAtCount(int i) {
        this.mData.aMN = i;
    }

    public int getChatCount() {
        return this.mData.aMO;
    }

    public void setChatCount(int i) {
        this.mData.aMO = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aMs;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aMs = z;
    }

    public int getNotificationCount() {
        return this.mData.aMP;
    }

    public void setNotificationCount(int i) {
        this.mData.aMP = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aMQ;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aMQ = z;
    }
}
