package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean cwU = false;
        private int cxp = 0;
        private int cxq = 0;
        private int cxr = 0;
        private int cxs = 0;
        private boolean cwW = false;
        private int cxt = 0;
        private boolean cxu = false;

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
        return this.mData.cwU;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.cwU = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.cxp;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.cxp = i;
    }

    public int getMsgReplyCount() {
        return this.mData.cxq;
    }

    public void setMsgReplyCount(int i) {
        this.mData.cxq = i;
    }

    public int getMsgAtCount() {
        return this.mData.cxr;
    }

    public void setMsgAtCount(int i) {
        this.mData.cxr = i;
    }

    public int getChatCount() {
        return this.mData.cxs;
    }

    public void setChatCount(int i) {
        this.mData.cxs = i;
    }

    public boolean hasChatRemind() {
        return this.mData.cwW;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.cwW = z;
    }

    public int getNotificationCount() {
        return this.mData.cxt;
    }

    public void setNotificationCount(int i) {
        this.mData.cxt = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.cxu;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.cxu = z;
    }
}
