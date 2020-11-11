package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean feS = false;
        private int ffl = 0;
        private int ffm = 0;
        private int ffn = 0;
        private int ffo = 0;
        private int ffp = 0;
        private boolean feU = false;
        private int ffq = 0;
        private boolean ffr = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.ffo;
    }

    public void setMsgFansCount(int i) {
        this.mData.ffo = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.feS;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.feS = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.ffl;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.ffl = i;
    }

    public int getMsgReplyCount() {
        return this.mData.ffm;
    }

    public void setMsgReplyCount(int i) {
        this.mData.ffm = i;
    }

    public int getMsgAtCount() {
        return this.mData.ffn;
    }

    public void setMsgAtCount(int i) {
        this.mData.ffn = i;
    }

    public int getChatCount() {
        return this.mData.ffp;
    }

    public void setChatCount(int i) {
        this.mData.ffp = i;
    }

    public boolean hasChatRemind() {
        return this.mData.feU;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.feU = z;
    }

    public int getNotificationCount() {
        return this.mData.ffq;
    }

    public void setNotificationCount(int i) {
        this.mData.ffq = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.ffr;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.ffr = z;
    }
}
