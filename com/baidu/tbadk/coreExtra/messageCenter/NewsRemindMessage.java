package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bYW = false;
        private int bZr = 0;
        private int bZs = 0;
        private int bZt = 0;
        private int bZu = 0;
        private boolean bYY = false;
        private int bZv = 0;
        private boolean bZw = false;

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
        return this.mData.bYW;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bYW = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bZr;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bZr = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bZs;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bZs = i;
    }

    public int getMsgAtCount() {
        return this.mData.bZt;
    }

    public void setMsgAtCount(int i) {
        this.mData.bZt = i;
    }

    public int getChatCount() {
        return this.mData.bZu;
    }

    public void setChatCount(int i) {
        this.mData.bZu = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bYY;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bYY = z;
    }

    public int getNotificationCount() {
        return this.mData.bZv;
    }

    public void setNotificationCount(int i) {
        this.mData.bZv = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bZw;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bZw = z;
    }
}
