package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean aCY = false;
        private int aDt = 0;
        private int aDu = 0;
        private int aDv = 0;
        private int aDw = 0;
        private boolean aDa = false;
        private int aDx = 0;
        private boolean aDy = false;

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
        return this.mData.aCY;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.aCY = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.aDt;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.aDt = i;
    }

    public int getMsgReplyCount() {
        return this.mData.aDu;
    }

    public void setMsgReplyCount(int i) {
        this.mData.aDu = i;
    }

    public int getMsgAtCount() {
        return this.mData.aDv;
    }

    public void setMsgAtCount(int i) {
        this.mData.aDv = i;
    }

    public int getChatCount() {
        return this.mData.aDw;
    }

    public void setChatCount(int i) {
        this.mData.aDw = i;
    }

    public boolean hasChatRemind() {
        return this.mData.aDa;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.aDa = z;
    }

    public int getNotificationCount() {
        return this.mData.aDx;
    }

    public void setNotificationCount(int i) {
        this.mData.aDx = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.aDy;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.aDy = z;
    }
}
