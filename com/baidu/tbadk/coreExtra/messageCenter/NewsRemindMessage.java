package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int msgCount = 0;
        private boolean edb = false;
        private int edw = 0;
        private int edx = 0;
        private int edy = 0;
        private int edz = 0;
        private boolean edd = false;
        private int edA = 0;
        private boolean edB = false;

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
        return this.mData.edb;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.edb = z;
    }

    public int getMsgAgreeCount() {
        return this.mData.edw;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.edw = i;
    }

    public int getMsgReplyCount() {
        return this.mData.edx;
    }

    public void setMsgReplyCount(int i) {
        this.mData.edx = i;
    }

    public int getMsgAtCount() {
        return this.mData.edy;
    }

    public void setMsgAtCount(int i) {
        this.mData.edy = i;
    }

    public int getChatCount() {
        return this.mData.edz;
    }

    public void setChatCount(int i) {
        this.mData.edz = i;
    }

    public boolean hasChatRemind() {
        return this.mData.edd;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.edd = z;
    }

    public int getNotificationCount() {
        return this.mData.edA;
    }

    public void setNotificationCount(int i) {
        this.mData.edA = i;
    }

    public boolean hasNotificationRemind() {
        return this.mData.edB;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.edB = z;
    }
}
