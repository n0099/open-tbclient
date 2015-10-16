package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int agK = 0;
        private int agL = 0;
        private int agM = 0;
        private int agO = 0;
        private int agN = 0;
        private int agP = 0;
        private int anA = 0;
        private int anB = 0;
        private int agQ = 0;

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
        this.mData.agK = i;
        this.mData.agL = i2;
        this.mData.agM = i3;
        this.mData.agN = i4;
        this.mData.agP = i5;
        this.mData.anA = i6;
    }

    public int getMsgReplyme() {
        return this.mData.agK;
    }

    public void setMsgReplyme(int i) {
        this.mData.agK = i;
    }

    public int getMsgAtme() {
        return this.mData.agL;
    }

    public void setMsgAtme(int i) {
        this.mData.agL = i;
    }

    public int getMsgChat() {
        return this.mData.agM;
    }

    public void setMsgChat(int i) {
        this.mData.agM = i;
    }

    public void setMsgFans(int i) {
        this.mData.agO = i;
    }

    public int getMsgFans() {
        return this.mData.agO;
    }

    public int getMsgBookmark() {
        return this.mData.agN;
    }

    public void setMsgBookmark(int i) {
        this.mData.agN = i;
    }

    public int getMsgGiftNum() {
        return this.mData.agP;
    }

    public void setMsgGiftNum(int i) {
        this.mData.agP = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.anA = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.anA;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.anB = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.anB;
    }

    public void setMsgLiveVip(int i) {
        this.mData.agQ = i;
    }

    public int getMsgLiveVip() {
        return this.mData.agQ;
    }
}
