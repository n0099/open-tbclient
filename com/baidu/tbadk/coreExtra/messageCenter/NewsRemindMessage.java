package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean fvk = false;
        private int fvD = 0;
        private int fvE = 0;
        private int fvF = 0;
        private int fvG = 0;
        private int fvH = 0;
        private boolean fvm = false;
        private int fvI = 0;
        private boolean fvJ = false;

        public a() {
        }
    }

    public NewsRemindMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_REMIND);
        this.mData = new a();
    }

    public int getMsgFansCount() {
        return this.mData.fvG;
    }

    public void setMsgFansCount(int i) {
        this.mData.fvG = i;
    }

    public int getMsgCount() {
        return this.mData.msgCount;
    }

    public void setMsgCount(int i) {
        this.mData.msgCount = i;
    }

    public boolean hasMsgRemind() {
        return this.mData.fvk;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.fvk = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.fvD;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.fvD = i;
    }

    public int getMsgReplyCount() {
        return this.mData.fvE;
    }

    public void setMsgReplyCount(int i) {
        this.mData.fvE = i;
    }

    public int getMsgAtCount() {
        return this.mData.fvF;
    }

    public void setMsgAtCount(int i) {
        this.mData.fvF = i;
    }

    public int getChatCount() {
        return this.mData.fvH;
    }

    public void setChatCount(int i) {
        this.mData.fvH = i;
    }

    public boolean hasChatRemind() {
        return this.mData.fvm;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.fvm = z;
    }

    public int getNotificationCount() {
        return this.mData.fvI;
    }

    public void setNotificationCount(int i) {
        this.mData.fvI = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.fvJ;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.fvJ = z;
    }
}
