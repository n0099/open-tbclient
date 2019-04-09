package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean bZa = false;
        private int bZv = 0;
        private int bZw = 0;
        private int bZx = 0;
        private int bZy = 0;
        private boolean bZc = false;
        private int bZz = 0;
        private boolean bZA = false;

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
        return this.mData.bZa;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.bZa = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.bZv;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.bZv = i;
    }

    public int getMsgReplyCount() {
        return this.mData.bZw;
    }

    public void setMsgReplyCount(int i) {
        this.mData.bZw = i;
    }

    public int getMsgAtCount() {
        return this.mData.bZx;
    }

    public void setMsgAtCount(int i) {
        this.mData.bZx = i;
    }

    public int getChatCount() {
        return this.mData.bZy;
    }

    public void setChatCount(int i) {
        this.mData.bZy = i;
    }

    public boolean hasChatRemind() {
        return this.mData.bZc;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.bZc = z;
    }

    public int getNotificationCount() {
        return this.mData.bZz;
    }

    public void setNotificationCount(int i) {
        this.mData.bZz = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.bZA;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.bZA = z;
    }
}
