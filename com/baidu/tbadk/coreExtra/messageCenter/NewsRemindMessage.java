package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bjs = false;
        private int bjN = 0;
        private int bjO = 0;
        private int bjP = 0;
        private int bjQ = 0;
        private boolean bju = false;
        private int bjR = 0;
        private boolean bjS = false;

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
        return this.mData.bjs;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bjs = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bjN;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bjN = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bjO;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bjO = i;
    }

    public int getMsgAtCount() {
        return this.mData.bjP;
    }

    public void setMsgAtCount(int i) {
        this.mData.bjP = i;
    }

    public int getChatCount() {
        return this.mData.bjQ;
    }

    public void setChatCount(int i) {
        this.mData.bjQ = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bju;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bju = z;
    }

    public int getNotificationCount() {
        return this.mData.bjR;
    }

    public void setNotificationCount(int i) {
        this.mData.bjR = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bjS;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bjS = z;
    }
}
