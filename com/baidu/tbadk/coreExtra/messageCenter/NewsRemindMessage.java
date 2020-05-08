package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean dOK = false;
        private int dPf = 0;
        private int dPg = 0;
        private int dPh = 0;
        private int dPi = 0;
        private boolean dOM = false;
        private int dPj = 0;
        private boolean dPk = false;

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
        return this.mData.dOK;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.dOK = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.dPf;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.dPf = i;
    }

    public int getMsgReplyCount() {
        return this.mData.dPg;
    }

    public void setMsgReplyCount(int i) {
        this.mData.dPg = i;
    }

    public int getMsgAtCount() {
        return this.mData.dPh;
    }

    public void setMsgAtCount(int i) {
        this.mData.dPh = i;
    }

    public int getChatCount() {
        return this.mData.dPi;
    }

    public void setChatCount(int i) {
        this.mData.dPi = i;
    }

    public boolean hasChatRemind() {
        return this.mData.dOM;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.dOM = z;
    }

    public int getNotificationCount() {
        return this.mData.dPj;
    }

    public void setNotificationCount(int i) {
        this.mData.dPj = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dPk;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dPk = z;
    }
}
