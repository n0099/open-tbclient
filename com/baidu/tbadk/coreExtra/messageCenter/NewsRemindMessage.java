package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cjg = false;
        private int cjB = 0;
        private int cjC = 0;
        private int cjD = 0;
        private int cjE = 0;
        private boolean cji = false;
        private int cjF = 0;
        private boolean cjG = false;

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
        return this.mData.cjg;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cjg = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.cjB;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.cjB = i;
    }

    public int getMsgReplyCount() {
        return this.mData.cjC;
    }

    public void setMsgReplyCount(int i) {
        this.mData.cjC = i;
    }

    public int getMsgAtCount() {
        return this.mData.cjD;
    }

    public void setMsgAtCount(int i) {
        this.mData.cjD = i;
    }

    public int getChatCount() {
        return this.mData.cjE;
    }

    public void setChatCount(int i) {
        this.mData.cjE = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cji;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cji = z;
    }

    public int getNotificationCount() {
        return this.mData.cjF;
    }

    public void setNotificationCount(int i) {
        this.mData.cjF = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.cjG;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.cjG = z;
    }
}
