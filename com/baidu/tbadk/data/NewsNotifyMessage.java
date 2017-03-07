package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int apG = 0;
        private int apH = 0;
        private int apI = 0;
        private int apK = 0;
        private int apJ = 0;
        private int apL = 0;
        private int axs = 0;
        private int axt = 0;
        private int apM = 0;
        private int axu = 0;

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
        this.mData.apG = i;
        this.mData.apH = i2;
        this.mData.apI = i3;
        this.mData.apJ = i4;
        this.mData.apL = i5;
        this.mData.axs = i6;
    }

    public int getMsgReplyme() {
        return this.mData.apG;
    }

    public void setMsgReplyme(int i) {
        this.mData.apG = i;
    }

    public int getMsgAtme() {
        return this.mData.apH;
    }

    public void setMsgAtme(int i) {
        this.mData.apH = i;
    }

    public int getMsgChat() {
        return this.mData.apI;
    }

    public void setMsgChat(int i) {
        this.mData.apI = i;
    }

    public void setMsgFans(int i) {
        this.mData.apK = i;
    }

    public int getMsgFans() {
        return this.mData.apK;
    }

    public int getMsgBookmark() {
        return this.mData.apJ;
    }

    public void setMsgBookmark(int i) {
        this.mData.apJ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.apL;
    }

    public void setMsgGiftNum(int i) {
        this.mData.apL = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.axs = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.axs;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.axt = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.axt;
    }

    public void setMsgLiveVip(int i) {
        this.mData.apM = i;
    }

    public int getMsgLiveVip() {
        return this.mData.apM;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.axu = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.axu;
    }
}
