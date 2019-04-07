package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bYF = 0;
        private int bYG = 0;
        private int bYH = 0;
        private int bYI = 0;
        private int bYK = 0;
        private int bYJ = 0;
        private int bYL = 0;
        private int chg = 0;
        private int chh = 0;
        private int chi = 0;

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
        this.mData.bYF = i;
        this.mData.bYG = i2;
        this.mData.bYH = i3;
        this.mData.bYI = i4;
        this.mData.bYJ = i5;
        this.mData.bYL = i6;
        this.mData.chg = i7;
    }

    public int getMsgAgree() {
        return this.mData.bYF;
    }

    public void setMsgAgree(int i) {
        this.mData.bYF = i;
    }

    public int getMsgReplyme() {
        return this.mData.bYG;
    }

    public void setMsgReplyme(int i) {
        this.mData.bYG = i;
    }

    public int getMsgAtme() {
        return this.mData.bYH;
    }

    public void setMsgAtme(int i) {
        this.mData.bYH = i;
    }

    public int getMsgChat() {
        return this.mData.bYI;
    }

    public void setMsgChat(int i) {
        this.mData.bYI = i;
    }

    public void setMsgFans(int i) {
        this.mData.bYK = i;
    }

    public int getMsgFans() {
        return this.mData.bYK;
    }

    public int getMsgBookmark() {
        return this.mData.bYJ;
    }

    public void setMsgBookmark(int i) {
        this.mData.bYJ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bYL;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bYL = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.chg = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.chg;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.chh = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.chh;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.chi = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.chi;
    }
}
