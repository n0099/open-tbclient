package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean erW = false;
        private int esp = 0;
        private int esq = 0;
        private int esr = 0;
        private int ess = 0;
        private int est = 0;
        private boolean erY = false;
        private int esu = 0;
        private boolean esv = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.ess;
    }

    public void setMsgFansCount(int i) {
        this.mData.ess = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.erW;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.erW = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.esp;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.esp = i;
    }

    public int getMsgReplyCount() {
        return this.mData.esq;
    }

    public void setMsgReplyCount(int i) {
        this.mData.esq = i;
    }

    public int getMsgAtCount() {
        return this.mData.esr;
    }

    public void setMsgAtCount(int i) {
        this.mData.esr = i;
    }

    public int getChatCount() {
        return this.mData.est;
    }

    public void setChatCount(int i) {
        this.mData.est = i;
    }

    public boolean hasChatRemind() {
        return this.mData.erY;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.erY = z;
    }

    public int getNotificationCount() {
        return this.mData.esu;
    }

    public void setNotificationCount(int i) {
        this.mData.esu = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.esv;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.esv = z;
    }
}
