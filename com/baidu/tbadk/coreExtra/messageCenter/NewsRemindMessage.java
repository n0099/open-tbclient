package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean fea = false;
        private int fet = 0;
        private int feu = 0;
        private int fev = 0;
        private int few = 0;
        private int fex = 0;
        private boolean fec = false;
        private int fey = 0;
        private boolean fez = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.few;
    }

    public void setMsgFansCount(int i) {
        this.mData.few = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.fea;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.fea = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.fet;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.fet = i;
    }

    public int getMsgReplyCount() {
        return this.mData.feu;
    }

    public void setMsgReplyCount(int i) {
        this.mData.feu = i;
    }

    public int getMsgAtCount() {
        return this.mData.fev;
    }

    public void setMsgAtCount(int i) {
        this.mData.fev = i;
    }

    public int getChatCount() {
        return this.mData.fex;
    }

    public void setChatCount(int i) {
        this.mData.fex = i;
    }

    public boolean hasChatRemind() {
        return this.mData.fec;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.fec = z;
    }

    public int getNotificationCount() {
        return this.mData.fey;
    }

    public void setNotificationCount(int i) {
        this.mData.fey = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.fez;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.fez = z;
    }
}
