package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aDy = 0;
        private int aDz = 0;
        private int aDA = 0;
        private int aDB = 0;
        private int aDD = 0;
        private int aDC = 0;
        private int aDE = 0;
        private int aKT = 0;
        private int aKU = 0;
        private int aKV = 0;

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
        this.mData.aDy = i;
        this.mData.aDz = i2;
        this.mData.aDA = i3;
        this.mData.aDB = i4;
        this.mData.aDC = i5;
        this.mData.aDE = i6;
        this.mData.aKT = i7;
    }

    public int getMsgAgree() {
        return this.mData.aDy;
    }

    public void setMsgAgree(int i) {
        this.mData.aDy = i;
    }

    public int getMsgReplyme() {
        return this.mData.aDz;
    }

    public void setMsgReplyme(int i) {
        this.mData.aDz = i;
    }

    public int getMsgAtme() {
        return this.mData.aDA;
    }

    public void setMsgAtme(int i) {
        this.mData.aDA = i;
    }

    public int getMsgChat() {
        return this.mData.aDB;
    }

    public void setMsgChat(int i) {
        this.mData.aDB = i;
    }

    public void setMsgFans(int i) {
        this.mData.aDD = i;
    }

    public int getMsgFans() {
        return this.mData.aDD;
    }

    public int getMsgBookmark() {
        return this.mData.aDC;
    }

    public void setMsgBookmark(int i) {
        this.mData.aDC = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aDE;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aDE = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aKT = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aKT;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aKU = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aKU;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aKV = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aKV;
    }
}
