package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int biP = 0;
        private int biQ = 0;
        private int biR = 0;
        private int biS = 0;
        private int biU = 0;
        private int biT = 0;
        private int biV = 0;
        private int bqY = 0;
        private int bqZ = 0;
        private int bra = 0;

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
        this.mData.biP = i;
        this.mData.biQ = i2;
        this.mData.biR = i3;
        this.mData.biS = i4;
        this.mData.biT = i5;
        this.mData.biV = i6;
        this.mData.bqY = i7;
    }

    public int getMsgAgree() {
        return this.mData.biP;
    }

    public void setMsgAgree(int i) {
        this.mData.biP = i;
    }

    public int getMsgReplyme() {
        return this.mData.biQ;
    }

    public void setMsgReplyme(int i) {
        this.mData.biQ = i;
    }

    public int getMsgAtme() {
        return this.mData.biR;
    }

    public void setMsgAtme(int i) {
        this.mData.biR = i;
    }

    public int getMsgChat() {
        return this.mData.biS;
    }

    public void setMsgChat(int i) {
        this.mData.biS = i;
    }

    public void setMsgFans(int i) {
        this.mData.biU = i;
    }

    public int getMsgFans() {
        return this.mData.biU;
    }

    public int getMsgBookmark() {
        return this.mData.biT;
    }

    public void setMsgBookmark(int i) {
        this.mData.biT = i;
    }

    public int getMsgGiftNum() {
        return this.mData.biV;
    }

    public void setMsgGiftNum(int i) {
        this.mData.biV = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.bqY = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.bqY;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.bqZ = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.bqZ;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.bra = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.bra;
    }
}
