package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aDS = false;
        private int aEn = 0;
        private int aEo = 0;
        private int aEp = 0;
        private int aEq = 0;
        private boolean aDU = false;
        private int aEr = 0;
        private boolean aEs = false;

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
        return this.mData.aDS;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aDS = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aEn;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aEn = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aEo;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aEo = i;
    }

    public int getMsgAtCount() {
        return this.mData.aEp;
    }

    public void setMsgAtCount(int i) {
        this.mData.aEp = i;
    }

    public int getChatCount() {
        return this.mData.aEq;
    }

    public void setChatCount(int i) {
        this.mData.aEq = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aDU;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aDU = z;
    }

    public int getNotificationCount() {
        return this.mData.aEr;
    }

    public void setNotificationCount(int i) {
        this.mData.aEr = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aEs;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aEs = z;
    }
}
