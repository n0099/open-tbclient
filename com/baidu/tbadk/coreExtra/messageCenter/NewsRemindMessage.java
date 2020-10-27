package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean eZb = false;
        private int eZu = 0;
        private int eZv = 0;
        private int eZw = 0;
        private int eZx = 0;
        private int eZy = 0;
        private boolean eZd = false;
        private int eZz = 0;
        private boolean eZA = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.eZx;
    }

    public void setMsgFansCount(int i) {
        this.mData.eZx = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.eZb;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.eZb = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.eZu;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.eZu = i;
    }

    public int getMsgReplyCount() {
        return this.mData.eZv;
    }

    public void setMsgReplyCount(int i) {
        this.mData.eZv = i;
    }

    public int getMsgAtCount() {
        return this.mData.eZw;
    }

    public void setMsgAtCount(int i) {
        this.mData.eZw = i;
    }

    public int getChatCount() {
        return this.mData.eZy;
    }

    public void setChatCount(int i) {
        this.mData.eZy = i;
    }

    public boolean hasChatRemind() {
        return this.mData.eZd;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.eZd = z;
    }

    public int getNotificationCount() {
        return this.mData.eZz;
    }

    public void setNotificationCount(int i) {
        this.mData.eZz = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.eZA;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.eZA = z;
    }
}
