package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aPx = 0;
        private int aPy = 0;
        private int aPz = 0;
        private int aPA = 0;
        private int aPC = 0;
        private int aPB = 0;
        private int aPD = 0;
        private int aXb = 0;
        private int aXc = 0;
        private int aXd = 0;

        public a() {
        }
    }

    public NewsNotifyMessage() {
        super(2001120);
        this.mData = new a();
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(2001120);
        this.mData = new a();
        this.mData.aPx = i;
        this.mData.aPy = i2;
        this.mData.aPz = i3;
        this.mData.aPA = i4;
        this.mData.aPB = i5;
        this.mData.aPD = i6;
        this.mData.aXb = i7;
    }

    public int getMsgAgree() {
        return this.mData.aPx;
    }

    public void setMsgAgree(int i) {
        this.mData.aPx = i;
    }

    public int getMsgReplyme() {
        return this.mData.aPy;
    }

    public void setMsgReplyme(int i) {
        this.mData.aPy = i;
    }

    public int getMsgAtme() {
        return this.mData.aPz;
    }

    public void setMsgAtme(int i) {
        this.mData.aPz = i;
    }

    public int getMsgChat() {
        return this.mData.aPA;
    }

    public void setMsgChat(int i) {
        this.mData.aPA = i;
    }

    public void setMsgFans(int i) {
        this.mData.aPC = i;
    }

    public int getMsgFans() {
        return this.mData.aPC;
    }

    public int getMsgBookmark() {
        return this.mData.aPB;
    }

    public void setMsgBookmark(int i) {
        this.mData.aPB = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aPD;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aPD = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aXb = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aXb;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aXc = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aXc;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aXd = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aXd;
    }
}
