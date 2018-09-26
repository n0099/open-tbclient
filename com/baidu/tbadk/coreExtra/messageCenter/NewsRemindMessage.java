package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aGX = false;
        private int aHs = 0;
        private int aHt = 0;
        private int aHu = 0;
        private int aHv = 0;
        private boolean aGZ = false;
        private int aHw = 0;
        private boolean aHx = false;

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
        return this.mData.aGX;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aGX = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aHs;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aHs = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aHt;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aHt = i;
    }

    public int getMsgAtCount() {
        return this.mData.aHu;
    }

    public void setMsgAtCount(int i) {
        this.mData.aHu = i;
    }

    public int getChatCount() {
        return this.mData.aHv;
    }

    public void setChatCount(int i) {
        this.mData.aHv = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aGZ;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aGZ = z;
    }

    public int getNotificationCount() {
        return this.mData.aHw;
    }

    public void setNotificationCount(int i) {
        this.mData.aHw = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aHx;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aHx = z;
    }
}
