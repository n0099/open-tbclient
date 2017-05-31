package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int apI = 0;
        private int apJ = 0;
        private int apK = 0;
        private int apM = 0;
        private int apL = 0;
        private int apN = 0;
        private int axt = 0;
        private int axu = 0;
        private int apO = 0;
        private int axv = 0;

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
        this.mData.apI = i;
        this.mData.apJ = i2;
        this.mData.apK = i3;
        this.mData.apL = i4;
        this.mData.apN = i5;
        this.mData.axt = i6;
    }

    public int getMsgReplyme() {
        return this.mData.apI;
    }

    public void setMsgReplyme(int i) {
        this.mData.apI = i;
    }

    public int getMsgAtme() {
        return this.mData.apJ;
    }

    public void setMsgAtme(int i) {
        this.mData.apJ = i;
    }

    public int getMsgChat() {
        return this.mData.apK;
    }

    public void setMsgChat(int i) {
        this.mData.apK = i;
    }

    public void setMsgFans(int i) {
        this.mData.apM = i;
    }

    public int getMsgFans() {
        return this.mData.apM;
    }

    public int getMsgBookmark() {
        return this.mData.apL;
    }

    public void setMsgBookmark(int i) {
        this.mData.apL = i;
    }

    public int getMsgGiftNum() {
        return this.mData.apN;
    }

    public void setMsgGiftNum(int i) {
        this.mData.apN = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.axt = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.axt;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.axu = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.axu;
    }

    public void setMsgLiveVip(int i) {
        this.mData.apO = i;
    }

    public int getMsgLiveVip() {
        return this.mData.apO;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.axv = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.axv;
    }
}
