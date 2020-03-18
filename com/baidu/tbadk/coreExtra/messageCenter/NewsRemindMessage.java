package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean doN = false;
        private int dpi = 0;
        private int dpj = 0;
        private int dpk = 0;
        private int dpl = 0;
        private boolean doP = false;
        private int dpm = 0;
        private boolean dpn = false;

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
        return this.mData.doN;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.doN = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.dpi;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.dpi = i;
    }

    public int getMsgReplyCount() {
        return this.mData.dpj;
    }

    public void setMsgReplyCount(int i) {
        this.mData.dpj = i;
    }

    public int getMsgAtCount() {
        return this.mData.dpk;
    }

    public void setMsgAtCount(int i) {
        this.mData.dpk = i;
    }

    public int getChatCount() {
        return this.mData.dpl;
    }

    public void setChatCount(int i) {
        this.mData.dpl = i;
    }

    public boolean hasChatRemind() {
        return this.mData.doP;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.doP = z;
    }

    public int getNotificationCount() {
        return this.mData.dpm;
    }

    public void setNotificationCount(int i) {
        this.mData.dpm = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.dpn;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.dpn = z;
    }
}
