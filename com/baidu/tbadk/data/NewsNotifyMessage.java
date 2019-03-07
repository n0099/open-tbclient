package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bYC = 0;
        private int bYD = 0;
        private int bYE = 0;
        private int bYF = 0;
        private int bYH = 0;
        private int bYG = 0;
        private int bYI = 0;
        private int che = 0;
        private int chf = 0;
        private int chg = 0;

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
        this.mData.bYC = i;
        this.mData.bYD = i2;
        this.mData.bYE = i3;
        this.mData.bYF = i4;
        this.mData.bYG = i5;
        this.mData.bYI = i6;
        this.mData.che = i7;
    }

    public int getMsgAgree() {
        return this.mData.bYC;
    }

    public void setMsgAgree(int i) {
        this.mData.bYC = i;
    }

    public int getMsgReplyme() {
        return this.mData.bYD;
    }

    public void setMsgReplyme(int i) {
        this.mData.bYD = i;
    }

    public int getMsgAtme() {
        return this.mData.bYE;
    }

    public void setMsgAtme(int i) {
        this.mData.bYE = i;
    }

    public int getMsgChat() {
        return this.mData.bYF;
    }

    public void setMsgChat(int i) {
        this.mData.bYF = i;
    }

    public void setMsgFans(int i) {
        this.mData.bYH = i;
    }

    public int getMsgFans() {
        return this.mData.bYH;
    }

    public int getMsgBookmark() {
        return this.mData.bYG;
    }

    public void setMsgBookmark(int i) {
        this.mData.bYG = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bYI;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bYI = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.che = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.che;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.chf = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.chf;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.chg = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.chg;
    }
}
