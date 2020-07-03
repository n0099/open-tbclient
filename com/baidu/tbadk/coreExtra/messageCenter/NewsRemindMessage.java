package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean elJ = false;
        private int eme = 0;
        private int emf = 0;
        private int emg = 0;
        private int emh = 0;
        private boolean elL = false;
        private int emi = 0;
        private boolean emj = false;

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
        return this.mData.elJ;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.elJ = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eme;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eme = i;
    }

    public int getMsgReplyCount() {
        return this.mData.emf;
    }

    public void setMsgReplyCount(int i) {
        this.mData.emf = i;
    }

    public int getMsgAtCount() {
        return this.mData.emg;
    }

    public void setMsgAtCount(int i) {
        this.mData.emg = i;
    }

    public int getChatCount() {
        return this.mData.emh;
    }

    public void setChatCount(int i) {
        this.mData.emh = i;
    }

    public boolean hasChatRemind() {
        return this.mData.elL;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.elL = z;
    }

    public int getNotificationCount() {
        return this.mData.emi;
    }

    public void setNotificationCount(int i) {
        this.mData.emi = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.emj;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.emj = z;
    }
}
