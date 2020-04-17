package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean dOF = false;
        private int dPa = 0;
        private int dPb = 0;
        private int dPc = 0;
        private int dPd = 0;
        private boolean dOH = false;
        private int dPe = 0;
        private boolean dPf = false;

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
        return this.mData.dOF;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.dOF = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.dPa;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.dPa = i;
    }

    public int getMsgReplyCount() {
        return this.mData.dPb;
    }

    public void setMsgReplyCount(int i) {
        this.mData.dPb = i;
    }

    public int getMsgAtCount() {
        return this.mData.dPc;
    }

    public void setMsgAtCount(int i) {
        this.mData.dPc = i;
    }

    public int getChatCount() {
        return this.mData.dPd;
    }

    public void setChatCount(int i) {
        this.mData.dPd = i;
    }

    public boolean hasChatRemind() {
        return this.mData.dOH;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.dOH = z;
    }

    public int getNotificationCount() {
        return this.mData.dPe;
    }

    public void setNotificationCount(int i) {
        this.mData.dPe = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dPf;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dPf = z;
    }
}
