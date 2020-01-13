package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean dkf = false;
        private int dkA = 0;
        private int dkB = 0;
        private int dkC = 0;
        private int dkD = 0;
        private boolean dkh = false;
        private int dkE = 0;
        private boolean dkF = false;

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
        return this.mData.dkf;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.dkf = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.dkA;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.dkA = i;
    }

    public int getMsgReplyCount() {
        return this.mData.dkB;
    }

    public void setMsgReplyCount(int i) {
        this.mData.dkB = i;
    }

    public int getMsgAtCount() {
        return this.mData.dkC;
    }

    public void setMsgAtCount(int i) {
        this.mData.dkC = i;
    }

    public int getChatCount() {
        return this.mData.dkD;
    }

    public void setChatCount(int i) {
        this.mData.dkD = i;
    }

    public boolean hasChatRemind() {
        return this.mData.dkh;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.dkh = z;
    }

    public int getNotificationCount() {
        return this.mData.dkE;
    }

    public void setNotificationCount(int i) {
        this.mData.dkE = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dkF;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dkF = z;
    }
}
