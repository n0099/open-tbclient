package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean fsS = false;
        private int ftl = 0;
        private int ftm = 0;
        private int ftn = 0;
        private int fto = 0;
        private int ftq = 0;
        private boolean fsU = false;
        private int ftr = 0;
        private boolean fts = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.fto;
    }

    public void setMsgFansCount(int i) {
        this.mData.fto = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.fsS;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.fsS = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.ftl;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.ftl = i;
    }

    public int getMsgReplyCount() {
        return this.mData.ftm;
    }

    public void setMsgReplyCount(int i) {
        this.mData.ftm = i;
    }

    public int getMsgAtCount() {
        return this.mData.ftn;
    }

    public void setMsgAtCount(int i) {
        this.mData.ftn = i;
    }

    public int getChatCount() {
        return this.mData.ftq;
    }

    public void setChatCount(int i) {
        this.mData.ftq = i;
    }

    public boolean hasChatRemind() {
        return this.mData.fsU;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.fsU = z;
    }

    public int getNotificationCount() {
        return this.mData.ftr;
    }

    public void setNotificationCount(int i) {
        this.mData.ftr = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.fts;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.fts = z;
    }
}
