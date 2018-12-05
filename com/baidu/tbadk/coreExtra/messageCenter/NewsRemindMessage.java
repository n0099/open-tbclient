package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aPP = false;
        private int aQk = 0;
        private int aQl = 0;
        private int aQm = 0;
        private int aQn = 0;
        private boolean aPR = false;
        private int aQo = 0;
        private boolean aQp = false;

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
        return this.mData.aPP;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aPP = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aQk;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aQk = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aQl;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aQl = i;
    }

    public int getMsgAtCount() {
        return this.mData.aQm;
    }

    public void setMsgAtCount(int i) {
        this.mData.aQm = i;
    }

    public int getChatCount() {
        return this.mData.aQn;
    }

    public void setChatCount(int i) {
        this.mData.aQn = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aPR;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aPR = z;
    }

    public int getNotificationCount() {
        return this.mData.aQo;
    }

    public void setNotificationCount(int i) {
        this.mData.aQo = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aQp;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aQp = z;
    }
}
