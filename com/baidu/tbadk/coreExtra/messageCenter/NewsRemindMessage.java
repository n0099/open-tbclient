package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean flz = false;
        private int flS = 0;
        private int flT = 0;
        private int flU = 0;
        private int flV = 0;
        private int flW = 0;
        private boolean flB = false;
        private int flX = 0;
        private boolean flY = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.flV;
    }

    public void setMsgFansCount(int i) {
        this.mData.flV = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.flz;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.flz = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.flS;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.flS = i;
    }

    public int getMsgReplyCount() {
        return this.mData.flT;
    }

    public void setMsgReplyCount(int i) {
        this.mData.flT = i;
    }

    public int getMsgAtCount() {
        return this.mData.flU;
    }

    public void setMsgAtCount(int i) {
        this.mData.flU = i;
    }

    public int getChatCount() {
        return this.mData.flW;
    }

    public void setChatCount(int i) {
        this.mData.flW = i;
    }

    public boolean hasChatRemind() {
        return this.mData.flB;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.flB = z;
    }

    public int getNotificationCount() {
        return this.mData.flX;
    }

    public void setNotificationCount(int i) {
        this.mData.flX = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.flY;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.flY = z;
    }
}
