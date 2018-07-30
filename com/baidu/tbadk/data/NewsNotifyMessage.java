package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aDz = 0;
        private int aDA = 0;
        private int aDB = 0;
        private int aDC = 0;
        private int aDE = 0;
        private int aDD = 0;
        private int aDF = 0;
        private int aKW = 0;
        private int aKX = 0;
        private int aKY = 0;

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
        this.mData.aDz = i;
        this.mData.aDA = i2;
        this.mData.aDB = i3;
        this.mData.aDC = i4;
        this.mData.aDD = i5;
        this.mData.aDF = i6;
        this.mData.aKW = i7;
    }

    public int getMsgAgree() {
        return this.mData.aDz;
    }

    public void setMsgAgree(int i) {
        this.mData.aDz = i;
    }

    public int getMsgReplyme() {
        return this.mData.aDA;
    }

    public void setMsgReplyme(int i) {
        this.mData.aDA = i;
    }

    public int getMsgAtme() {
        return this.mData.aDB;
    }

    public void setMsgAtme(int i) {
        this.mData.aDB = i;
    }

    public int getMsgChat() {
        return this.mData.aDC;
    }

    public void setMsgChat(int i) {
        this.mData.aDC = i;
    }

    public void setMsgFans(int i) {
        this.mData.aDE = i;
    }

    public int getMsgFans() {
        return this.mData.aDE;
    }

    public int getMsgBookmark() {
        return this.mData.aDD;
    }

    public void setMsgBookmark(int i) {
        this.mData.aDD = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aDF;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aDF = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aKW = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aKW;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aKX = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aKX;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aKY = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aKY;
    }
}
