package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean fqz = false;
        private int fqS = 0;
        private int fqT = 0;
        private int fqU = 0;
        private int fqV = 0;
        private int fqW = 0;
        private boolean fqB = false;
        private int fqX = 0;
        private boolean fqY = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.fqV;
    }

    public void setMsgFansCount(int i) {
        this.mData.fqV = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.fqz;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.fqz = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.fqS;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.fqS = i;
    }

    public int getMsgReplyCount() {
        return this.mData.fqT;
    }

    public void setMsgReplyCount(int i) {
        this.mData.fqT = i;
    }

    public int getMsgAtCount() {
        return this.mData.fqU;
    }

    public void setMsgAtCount(int i) {
        this.mData.fqU = i;
    }

    public int getChatCount() {
        return this.mData.fqW;
    }

    public void setChatCount(int i) {
        this.mData.fqW = i;
    }

    public boolean hasChatRemind() {
        return this.mData.fqB;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.fqB = z;
    }

    public int getNotificationCount() {
        return this.mData.fqX;
    }

    public void setNotificationCount(int i) {
        this.mData.fqX = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.fqY;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.fqY = z;
    }
}
