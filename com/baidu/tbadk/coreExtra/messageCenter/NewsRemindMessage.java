package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean eQF = false;
        private int eQY = 0;
        private int eQZ = 0;
        private int eRa = 0;
        private int eRb = 0;
        private int eRc = 0;
        private boolean eQH = false;
        private int eRd = 0;
        private boolean eRe = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.eRb;
    }

    public void setMsgFansCount(int i) {
        this.mData.eRb = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.eQF;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.eQF = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eQY;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eQY = i;
    }

    public int getMsgReplyCount() {
        return this.mData.eQZ;
    }

    public void setMsgReplyCount(int i) {
        this.mData.eQZ = i;
    }

    public int getMsgAtCount() {
        return this.mData.eRa;
    }

    public void setMsgAtCount(int i) {
        this.mData.eRa = i;
    }

    public int getChatCount() {
        return this.mData.eRc;
    }

    public void setChatCount(int i) {
        this.mData.eRc = i;
    }

    public boolean hasChatRemind() {
        return this.mData.eQH;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.eQH = z;
    }

    public int getNotificationCount() {
        return this.mData.eRd;
    }

    public void setNotificationCount(int i) {
        this.mData.eRd = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.eRe;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.eRe = z;
    }
}
