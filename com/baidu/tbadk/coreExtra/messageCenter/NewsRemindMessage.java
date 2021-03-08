package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean fus = false;
        private int fuL = 0;
        private int fuM = 0;
        private int fuN = 0;
        private int fuO = 0;
        private int fuP = 0;
        private boolean fuu = false;
        private int fuQ = 0;
        private boolean fuR = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.fuO;
    }

    public void setMsgFansCount(int i) {
        this.mData.fuO = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.fus;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.fus = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.fuL;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.fuL = i;
    }

    public int getMsgReplyCount() {
        return this.mData.fuM;
    }

    public void setMsgReplyCount(int i) {
        this.mData.fuM = i;
    }

    public int getMsgAtCount() {
        return this.mData.fuN;
    }

    public void setMsgAtCount(int i) {
        this.mData.fuN = i;
    }

    public int getChatCount() {
        return this.mData.fuP;
    }

    public void setChatCount(int i) {
        this.mData.fuP = i;
    }

    public boolean hasChatRemind() {
        return this.mData.fuu;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.fuu = z;
    }

    public int getNotificationCount() {
        return this.mData.fuQ;
    }

    public void setNotificationCount(int i) {
        this.mData.fuQ = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.fuR;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.fuR = z;
    }
}
