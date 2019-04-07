package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bYZ = false;
        private int bZu = 0;
        private int bZv = 0;
        private int bZw = 0;
        private int bZx = 0;
        private boolean bZb = false;
        private int bZy = 0;
        private boolean bZz = false;

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
        return this.mData.bYZ;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bYZ = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bZu;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bZu = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bZv;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bZv = i;
    }

    public int getMsgAtCount() {
        return this.mData.bZw;
    }

    public void setMsgAtCount(int i) {
        this.mData.bZw = i;
    }

    public int getChatCount() {
        return this.mData.bZx;
    }

    public void setChatCount(int i) {
        this.mData.bZx = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bZb;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bZb = z;
    }

    public int getNotificationCount() {
        return this.mData.bZy;
    }

    public void setNotificationCount(int i) {
        this.mData.bZy = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bZz;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bZz = z;
    }
}
