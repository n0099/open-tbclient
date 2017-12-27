package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bgv = 0;
        private int bgw = 0;
        private int bgx = 0;
        private int bgz = 0;
        private int bgy = 0;
        private int bgA = 0;
        private int boC = 0;
        private int boD = 0;
        private int bgB = 0;
        private int boE = 0;

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
        this.mData.bgv = i;
        this.mData.bgw = i2;
        this.mData.bgx = i3;
        this.mData.bgy = i4;
        this.mData.bgA = i5;
        this.mData.boC = i6;
    }

    public int getMsgReplyme() {
        return this.mData.bgv;
    }

    public void setMsgReplyme(int i) {
        this.mData.bgv = i;
    }

    public int getMsgAtme() {
        return this.mData.bgw;
    }

    public void setMsgAtme(int i) {
        this.mData.bgw = i;
    }

    public int getMsgChat() {
        return this.mData.bgx;
    }

    public void setMsgChat(int i) {
        this.mData.bgx = i;
    }

    public void setMsgFans(int i) {
        this.mData.bgz = i;
    }

    public int getMsgFans() {
        return this.mData.bgz;
    }

    public int getMsgBookmark() {
        return this.mData.bgy;
    }

    public void setMsgBookmark(int i) {
        this.mData.bgy = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bgA;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bgA = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.boC = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.boC;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.boD = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.boD;
    }

    public void setMsgLiveVip(int i) {
        this.mData.bgB = i;
    }

    public int getMsgLiveVip() {
        return this.mData.bgB;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.boE = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.boE;
    }
}
