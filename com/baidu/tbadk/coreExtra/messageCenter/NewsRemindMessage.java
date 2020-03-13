package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean doA = false;
        private int doV = 0;
        private int doW = 0;
        private int doX = 0;
        private int doY = 0;
        private boolean doC = false;
        private int doZ = 0;
        private boolean dpa = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.doA;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.doA = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.doV;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.doV = i;
    }

    public int getMsgReplyCount() {
        return this.mData.doW;
    }

    public void setMsgReplyCount(int i) {
        this.mData.doW = i;
    }

    public int getMsgAtCount() {
        return this.mData.doX;
    }

    public void setMsgAtCount(int i) {
        this.mData.doX = i;
    }

    public int getChatCount() {
        return this.mData.doY;
    }

    public void setChatCount(int i) {
        this.mData.doY = i;
    }

    public boolean hasChatRemind() {
        return this.mData.doC;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.doC = z;
    }

    public int getNotificationCount() {
        return this.mData.doZ;
    }

    public void setNotificationCount(int i) {
        this.mData.doZ = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dpa;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dpa = z;
    }
}
