package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cie = false;
        private int ciz = 0;
        private int ciA = 0;
        private int ciB = 0;
        private int ciC = 0;
        private boolean cig = false;
        private int ciD = 0;
        private boolean ciE = false;

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
        return this.mData.cie;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cie = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.ciz;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.ciz = i;
    }

    public int getMsgReplyCount() {
        return this.mData.ciA;
    }

    public void setMsgReplyCount(int i) {
        this.mData.ciA = i;
    }

    public int getMsgAtCount() {
        return this.mData.ciB;
    }

    public void setMsgAtCount(int i) {
        this.mData.ciB = i;
    }

    public int getChatCount() {
        return this.mData.ciC;
    }

    public void setChatCount(int i) {
        this.mData.ciC = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cig;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cig = z;
    }

    public int getNotificationCount() {
        return this.mData.ciD;
    }

    public void setNotificationCount(int i) {
        this.mData.ciD = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.ciE;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.ciE = z;
    }
}
