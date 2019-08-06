package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cil = false;
        private int ciG = 0;
        private int ciH = 0;
        private int ciI = 0;
        private int ciJ = 0;
        private boolean cin = false;
        private int ciK = 0;
        private boolean ciL = false;

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
        return this.mData.cil;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cil = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.ciG;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.ciG = i;
    }

    public int getMsgReplyCount() {
        return this.mData.ciH;
    }

    public void setMsgReplyCount(int i) {
        this.mData.ciH = i;
    }

    public int getMsgAtCount() {
        return this.mData.ciI;
    }

    public void setMsgAtCount(int i) {
        this.mData.ciI = i;
    }

    public int getChatCount() {
        return this.mData.ciJ;
    }

    public void setChatCount(int i) {
        this.mData.ciJ = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cin;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cin = z;
    }

    public int getNotificationCount() {
        return this.mData.ciK;
    }

    public void setNotificationCount(int i) {
        this.mData.ciK = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.ciL;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.ciL = z;
    }
}
