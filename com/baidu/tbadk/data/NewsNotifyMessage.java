package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aLW = 0;
        private int aLX = 0;
        private int aLY = 0;
        private int aLZ = 0;
        private int aMb = 0;
        private int aMa = 0;
        private int aMc = 0;
        private int aTB = 0;
        private int aTC = 0;
        private int aTD = 0;

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
        this.mData.aLW = i;
        this.mData.aLX = i2;
        this.mData.aLY = i3;
        this.mData.aLZ = i4;
        this.mData.aMa = i5;
        this.mData.aMc = i6;
        this.mData.aTB = i7;
    }

    public int getMsgAgree() {
        return this.mData.aLW;
    }

    public void setMsgAgree(int i) {
        this.mData.aLW = i;
    }

    public int getMsgReplyme() {
        return this.mData.aLX;
    }

    public void setMsgReplyme(int i) {
        this.mData.aLX = i;
    }

    public int getMsgAtme() {
        return this.mData.aLY;
    }

    public void setMsgAtme(int i) {
        this.mData.aLY = i;
    }

    public int getMsgChat() {
        return this.mData.aLZ;
    }

    public void setMsgChat(int i) {
        this.mData.aLZ = i;
    }

    public void setMsgFans(int i) {
        this.mData.aMb = i;
    }

    public int getMsgFans() {
        return this.mData.aMb;
    }

    public int getMsgBookmark() {
        return this.mData.aMa;
    }

    public void setMsgBookmark(int i) {
        this.mData.aMa = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aMc;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aMc = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aTB = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aTB;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aTC = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aTC;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aTD = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aTD;
    }
}
