package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aGD = 0;
        private int aGE = 0;
        private int aGF = 0;
        private int aGG = 0;
        private int aGI = 0;
        private int aGH = 0;
        private int aGJ = 0;
        private int aOj = 0;
        private int aOk = 0;
        private int aOl = 0;

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
        this.mData.aGD = i;
        this.mData.aGE = i2;
        this.mData.aGF = i3;
        this.mData.aGG = i4;
        this.mData.aGH = i5;
        this.mData.aGJ = i6;
        this.mData.aOj = i7;
    }

    public int getMsgAgree() {
        return this.mData.aGD;
    }

    public void setMsgAgree(int i) {
        this.mData.aGD = i;
    }

    public int getMsgReplyme() {
        return this.mData.aGE;
    }

    public void setMsgReplyme(int i) {
        this.mData.aGE = i;
    }

    public int getMsgAtme() {
        return this.mData.aGF;
    }

    public void setMsgAtme(int i) {
        this.mData.aGF = i;
    }

    public int getMsgChat() {
        return this.mData.aGG;
    }

    public void setMsgChat(int i) {
        this.mData.aGG = i;
    }

    public void setMsgFans(int i) {
        this.mData.aGI = i;
    }

    public int getMsgFans() {
        return this.mData.aGI;
    }

    public int getMsgBookmark() {
        return this.mData.aGH;
    }

    public void setMsgBookmark(int i) {
        this.mData.aGH = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aGJ;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aGJ = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aOj = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aOj;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aOk = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aOk;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aOl = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aOl;
    }
}
