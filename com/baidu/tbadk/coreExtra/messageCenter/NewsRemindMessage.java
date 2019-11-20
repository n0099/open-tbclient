package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cwd = false;
        private int cwy = 0;
        private int cwz = 0;
        private int cwA = 0;
        private int cwB = 0;
        private boolean cwf = false;
        private int cwC = 0;
        private boolean cwD = false;

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
        return this.mData.cwd;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cwd = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.cwy;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.cwy = i;
    }

    public int getMsgReplyCount() {
        return this.mData.cwz;
    }

    public void setMsgReplyCount(int i) {
        this.mData.cwz = i;
    }

    public int getMsgAtCount() {
        return this.mData.cwA;
    }

    public void setMsgAtCount(int i) {
        this.mData.cwA = i;
    }

    public int getChatCount() {
        return this.mData.cwB;
    }

    public void setChatCount(int i) {
        this.mData.cwB = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cwf;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cwf = z;
    }

    public int getNotificationCount() {
        return this.mData.cwC;
    }

    public void setNotificationCount(int i) {
        this.mData.cwC = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.cwD;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.cwD = z;
    }
}
