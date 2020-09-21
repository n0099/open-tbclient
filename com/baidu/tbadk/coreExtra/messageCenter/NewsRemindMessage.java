package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean eEy = false;
        private int eER = 0;
        private int eES = 0;
        private int eET = 0;
        private int eEU = 0;
        private int eEV = 0;
        private boolean eEA = false;
        private int eEW = 0;
        private boolean eEX = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.eEU;
    }

    public void setMsgFansCount(int i) {
        this.mData.eEU = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.eEy;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.eEy = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eER;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eER = i;
    }

    public int getMsgReplyCount() {
        return this.mData.eES;
    }

    public void setMsgReplyCount(int i) {
        this.mData.eES = i;
    }

    public int getMsgAtCount() {
        return this.mData.eET;
    }

    public void setMsgAtCount(int i) {
        this.mData.eET = i;
    }

    public int getChatCount() {
        return this.mData.eEV;
    }

    public void setChatCount(int i) {
        this.mData.eEV = i;
    }

    public boolean hasChatRemind() {
        return this.mData.eEA;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.eEA = z;
    }

    public int getNotificationCount() {
        return this.mData.eEW;
    }

    public void setNotificationCount(int i) {
        this.mData.eEW = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.eEX;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.eEX = z;
    }
}
