package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int agJ = 0;
        private int agK = 0;
        private int agL = 0;
        private int agN = 0;
        private int agM = 0;
        private int agO = 0;
        private int anz = 0;
        private int anA = 0;
        private int agP = 0;

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
        this.mData.agJ = i;
        this.mData.agK = i2;
        this.mData.agL = i3;
        this.mData.agM = i4;
        this.mData.agO = i5;
        this.mData.anz = i6;
    }

    public int getMsgReplyme() {
        return this.mData.agJ;
    }

    public void setMsgReplyme(int i) {
        this.mData.agJ = i;
    }

    public int getMsgAtme() {
        return this.mData.agK;
    }

    public void setMsgAtme(int i) {
        this.mData.agK = i;
    }

    public int getMsgChat() {
        return this.mData.agL;
    }

    public void setMsgChat(int i) {
        this.mData.agL = i;
    }

    public void setMsgFans(int i) {
        this.mData.agN = i;
    }

    public int getMsgFans() {
        return this.mData.agN;
    }

    public int getMsgBookmark() {
        return this.mData.agM;
    }

    public void setMsgBookmark(int i) {
        this.mData.agM = i;
    }

    public int getMsgGiftNum() {
        return this.mData.agO;
    }

    public void setMsgGiftNum(int i) {
        this.mData.agO = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.anz = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.anz;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.anA = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.anA;
    }

    public void setMsgLiveVip(int i) {
        this.mData.agP = i;
    }

    public int getMsgLiveVip() {
        return this.mData.agP;
    }
}
