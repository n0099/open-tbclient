package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int biM = 0;
        private int biN = 0;
        private int biO = 0;
        private int biP = 0;
        private int biR = 0;
        private int biQ = 0;
        private int biS = 0;
        private int bqV = 0;
        private int bqW = 0;
        private int bqX = 0;

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
        this.mData.biM = i;
        this.mData.biN = i2;
        this.mData.biO = i3;
        this.mData.biP = i4;
        this.mData.biQ = i5;
        this.mData.biS = i6;
        this.mData.bqV = i7;
    }

    public int getMsgAgree() {
        return this.mData.biM;
    }

    public void setMsgAgree(int i) {
        this.mData.biM = i;
    }

    public int getMsgReplyme() {
        return this.mData.biN;
    }

    public void setMsgReplyme(int i) {
        this.mData.biN = i;
    }

    public int getMsgAtme() {
        return this.mData.biO;
    }

    public void setMsgAtme(int i) {
        this.mData.biO = i;
    }

    public int getMsgChat() {
        return this.mData.biP;
    }

    public void setMsgChat(int i) {
        this.mData.biP = i;
    }

    public void setMsgFans(int i) {
        this.mData.biR = i;
    }

    public int getMsgFans() {
        return this.mData.biR;
    }

    public int getMsgBookmark() {
        return this.mData.biQ;
    }

    public void setMsgBookmark(int i) {
        this.mData.biQ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.biS;
    }

    public void setMsgGiftNum(int i) {
        this.mData.biS = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.bqV = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.bqV;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.bqW = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.bqW;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.bqX = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.bqX;
    }
}
