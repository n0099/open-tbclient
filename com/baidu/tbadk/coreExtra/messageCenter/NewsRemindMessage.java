package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean auM = false;
        private int avh = 0;
        private int avi = 0;
        private int avj = 0;
        private int avk = 0;
        private boolean auO = false;
        private int avl = 0;
        private boolean avm = false;

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
        return this.mData.auM;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.auM = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.avh;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.avh = i;
    }

    public int getMsgReplyCount() {
        return this.mData.avi;
    }

    public void setMsgReplyCount(int i) {
        this.mData.avi = i;
    }

    public int getMsgAtCount() {
        return this.mData.avj;
    }

    public void setMsgAtCount(int i) {
        this.mData.avj = i;
    }

    public int getChatCount() {
        return this.mData.avk;
    }

    public void setChatCount(int i) {
        this.mData.avk = i;
    }

    public boolean hasChatRemind() {
        return this.mData.auO;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.auO = z;
    }

    public int getNotificationCount() {
        return this.mData.avl;
    }

    public void setNotificationCount(int i) {
        this.mData.avl = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.avm;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.avm = z;
    }
}
