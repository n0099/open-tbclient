package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int arN = 0;
        private int arO = 0;
        private int arP = 0;
        private int arR = 0;
        private int arQ = 0;
        private int arS = 0;
        private int azP = 0;
        private int azQ = 0;
        private int arT = 0;
        private int azR = 0;

        public a() {
        }
    }

    public NewsNotifyMessage() {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new a();
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6) {
        super(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL);
        this.mData = new a();
        this.mData.arN = i;
        this.mData.arO = i2;
        this.mData.arP = i3;
        this.mData.arQ = i4;
        this.mData.arS = i5;
        this.mData.azP = i6;
    }

    public int getMsgReplyme() {
        return this.mData.arN;
    }

    public void setMsgReplyme(int i) {
        this.mData.arN = i;
    }

    public int getMsgAtme() {
        return this.mData.arO;
    }

    public void setMsgAtme(int i) {
        this.mData.arO = i;
    }

    public int getMsgChat() {
        return this.mData.arP;
    }

    public void setMsgChat(int i) {
        this.mData.arP = i;
    }

    public void setMsgFans(int i) {
        this.mData.arR = i;
    }

    public int getMsgFans() {
        return this.mData.arR;
    }

    public int getMsgBookmark() {
        return this.mData.arQ;
    }

    public void setMsgBookmark(int i) {
        this.mData.arQ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.arS;
    }

    public void setMsgGiftNum(int i) {
        this.mData.arS = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.azP = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.azP;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.azQ = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.azQ;
    }

    public void setMsgLiveVip(int i) {
        this.mData.arT = i;
    }

    public int getMsgLiveVip() {
        return this.mData.arT;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.azR = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.azR;
    }
}
