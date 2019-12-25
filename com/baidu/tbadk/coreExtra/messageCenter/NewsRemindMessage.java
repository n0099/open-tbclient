package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean djP = false;
        private int dkk = 0;
        private int dkl = 0;
        private int dkm = 0;
        private int dkn = 0;
        private boolean djR = false;
        private int dko = 0;
        private boolean dkp = false;

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
        return this.mData.djP;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.djP = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.dkk;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.dkk = i;
    }

    public int getMsgReplyCount() {
        return this.mData.dkl;
    }

    public void setMsgReplyCount(int i) {
        this.mData.dkl = i;
    }

    public int getMsgAtCount() {
        return this.mData.dkm;
    }

    public void setMsgAtCount(int i) {
        this.mData.dkm = i;
    }

    public int getChatCount() {
        return this.mData.dkn;
    }

    public void setChatCount(int i) {
        this.mData.dkn = i;
    }

    public boolean hasChatRemind() {
        return this.mData.djR;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.djR = z;
    }

    public int getNotificationCount() {
        return this.mData.dko;
    }

    public void setNotificationCount(int i) {
        this.mData.dko = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dkp;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dkp = z;
    }
}
