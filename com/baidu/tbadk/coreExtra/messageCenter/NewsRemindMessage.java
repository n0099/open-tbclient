package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean dol = false;
        private int doH = 0;
        private int doI = 0;
        private int doJ = 0;
        private int doK = 0;
        private boolean don = false;
        private int doL = 0;
        private boolean doM = false;

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
        return this.mData.dol;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.dol = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.doH;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.doH = i;
    }

    public int getMsgReplyCount() {
        return this.mData.doI;
    }

    public void setMsgReplyCount(int i) {
        this.mData.doI = i;
    }

    public int getMsgAtCount() {
        return this.mData.doJ;
    }

    public void setMsgAtCount(int i) {
        this.mData.doJ = i;
    }

    public int getChatCount() {
        return this.mData.doK;
    }

    public void setChatCount(int i) {
        this.mData.doK = i;
    }

    public boolean hasChatRemind() {
        return this.mData.don;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.don = z;
    }

    public int getNotificationCount() {
        return this.mData.doL;
    }

    public void setNotificationCount(int i) {
        this.mData.doL = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.doM;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.doM = z;
    }
}
