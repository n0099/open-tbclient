package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bji = false;
        private int bjD = 0;
        private int bjE = 0;
        private int bjF = 0;
        private int bjG = 0;
        private boolean bjk = false;
        private int bjH = 0;
        private boolean bjI = false;

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
        return this.mData.bji;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bji = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bjD;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bjD = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bjE;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bjE = i;
    }

    public int getMsgAtCount() {
        return this.mData.bjF;
    }

    public void setMsgAtCount(int i) {
        this.mData.bjF = i;
    }

    public int getChatCount() {
        return this.mData.bjG;
    }

    public void setChatCount(int i) {
        this.mData.bjG = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bjk;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bjk = z;
    }

    public int getNotificationCount() {
        return this.mData.bjH;
    }

    public void setNotificationCount(int i) {
        this.mData.bjH = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bjI;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bjI = z;
    }
}
