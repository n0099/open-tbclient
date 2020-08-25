package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes2.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes2.dex */
    public class a {
        private int msgCount = 0;
        private boolean eCp = false;
        private int eCI = 0;
        private int eCJ = 0;
        private int eCK = 0;
        private int eCL = 0;
        private int eCM = 0;
        private boolean eCr = false;
        private int eCN = 0;
        private boolean eCO = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.eCL;
    }

    public void setMsgFansCount(int i) {
        this.mData.eCL = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.eCp;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.eCp = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eCI;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eCI = i;
    }

    public int getMsgReplyCount() {
        return this.mData.eCJ;
    }

    public void setMsgReplyCount(int i) {
        this.mData.eCJ = i;
    }

    public int getMsgAtCount() {
        return this.mData.eCK;
    }

    public void setMsgAtCount(int i) {
        this.mData.eCK = i;
    }

    public int getChatCount() {
        return this.mData.eCM;
    }

    public void setChatCount(int i) {
        this.mData.eCM = i;
    }

    public boolean hasChatRemind() {
        return this.mData.eCr;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.eCr = z;
    }

    public int getNotificationCount() {
        return this.mData.eCN;
    }

    public void setNotificationCount(int i) {
        this.mData.eCN = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.eCO;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.eCO = z;
    }
}
