package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aLA = false;
        private int aLV = 0;
        private int aLW = 0;
        private int aLX = 0;
        private int aLY = 0;
        private boolean aLC = false;
        private int aLZ = 0;
        private boolean aMa = false;

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
        return this.mData.aLA;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aLA = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aLV;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aLV = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aLW;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aLW = i;
    }

    public int getMsgAtCount() {
        return this.mData.aLX;
    }

    public void setMsgAtCount(int i) {
        this.mData.aLX = i;
    }

    public int getChatCount() {
        return this.mData.aLY;
    }

    public void setChatCount(int i) {
        this.mData.aLY = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aLC;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aLC = z;
    }

    public int getNotificationCount() {
        return this.mData.aLZ;
    }

    public void setNotificationCount(int i) {
        this.mData.aLZ = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aMa;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aMa = z;
    }
}
