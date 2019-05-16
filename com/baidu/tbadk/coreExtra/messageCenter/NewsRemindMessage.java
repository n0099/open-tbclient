package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cgX = false;
        private int chs = 0;
        private int cht = 0;
        private int chu = 0;
        private int chv = 0;
        private boolean cgZ = false;
        private int chw = 0;
        private boolean chx = false;

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
        return this.mData.cgX;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cgX = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.chs;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.chs = i;
    }

    public int getMsgReplyCount() {
        return this.mData.cht;
    }

    public void setMsgReplyCount(int i) {
        this.mData.cht = i;
    }

    public int getMsgAtCount() {
        return this.mData.chu;
    }

    public void setMsgAtCount(int i) {
        this.mData.chu = i;
    }

    public int getChatCount() {
        return this.mData.chv;
    }

    public void setChatCount(int i) {
        this.mData.chv = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cgZ;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cgZ = z;
    }

    public int getNotificationCount() {
        return this.mData.chw;
    }

    public void setNotificationCount(int i) {
        this.mData.chw = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.chx;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.chx = z;
    }
}
