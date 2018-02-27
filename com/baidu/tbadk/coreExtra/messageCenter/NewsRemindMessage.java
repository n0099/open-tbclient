package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bjf = false;
        private int bjA = 0;
        private int bjB = 0;
        private int bjC = 0;
        private int bjD = 0;
        private boolean bjh = false;
        private int bjE = 0;
        private boolean bjF = false;

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
        return this.mData.bjf;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bjf = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bjA;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bjA = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bjB;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bjB = i;
    }

    public int getMsgAtCount() {
        return this.mData.bjC;
    }

    public void setMsgAtCount(int i) {
        this.mData.bjC = i;
    }

    public int getChatCount() {
        return this.mData.bjD;
    }

    public void setChatCount(int i) {
        this.mData.bjD = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bjh;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bjh = z;
    }

    public int getNotificationCount() {
        return this.mData.bjE;
    }

    public void setNotificationCount(int i) {
        this.mData.bjE = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bjF;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bjF = z;
    }
}
