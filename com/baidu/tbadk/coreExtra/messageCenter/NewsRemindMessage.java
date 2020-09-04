package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean eCt = false;
        private int eCM = 0;
        private int eCN = 0;
        private int eCO = 0;
        private int eCP = 0;
        private int eCQ = 0;
        private boolean eCv = false;
        private int eCR = 0;
        private boolean eCS = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.eCP;
    }

    public void setMsgFansCount(int i) {
        this.mData.eCP = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.eCt;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.eCt = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eCM;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eCM = i;
    }

    public int getMsgReplyCount() {
        return this.mData.eCN;
    }

    public void setMsgReplyCount(int i) {
        this.mData.eCN = i;
    }

    public int getMsgAtCount() {
        return this.mData.eCO;
    }

    public void setMsgAtCount(int i) {
        this.mData.eCO = i;
    }

    public int getChatCount() {
        return this.mData.eCQ;
    }

    public void setChatCount(int i) {
        this.mData.eCQ = i;
    }

    public boolean hasChatRemind() {
        return this.mData.eCv;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.eCv = z;
    }

    public int getNotificationCount() {
        return this.mData.eCR;
    }

    public void setNotificationCount(int i) {
        this.mData.eCR = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.eCS;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.eCS = z;
    }
}
