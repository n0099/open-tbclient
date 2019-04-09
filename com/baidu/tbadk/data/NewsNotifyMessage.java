package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int bYG = 0;
        private int bYH = 0;
        private int bYI = 0;
        private int bYJ = 0;
        private int bYL = 0;
        private int bYK = 0;
        private int bYM = 0;
        private int chh = 0;
        private int chi = 0;
        private int chj = 0;

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
        this.mData.bYG = i;
        this.mData.bYH = i2;
        this.mData.bYI = i3;
        this.mData.bYJ = i4;
        this.mData.bYK = i5;
        this.mData.bYM = i6;
        this.mData.chh = i7;
    }

    public int getMsgAgree() {
        return this.mData.bYG;
    }

    public void setMsgAgree(int i) {
        this.mData.bYG = i;
    }

    public int getMsgReplyme() {
        return this.mData.bYH;
    }

    public void setMsgReplyme(int i) {
        this.mData.bYH = i;
    }

    public int getMsgAtme() {
        return this.mData.bYI;
    }

    public void setMsgAtme(int i) {
        this.mData.bYI = i;
    }

    public int getMsgChat() {
        return this.mData.bYJ;
    }

    public void setMsgChat(int i) {
        this.mData.bYJ = i;
    }

    public void setMsgFans(int i) {
        this.mData.bYL = i;
    }

    public int getMsgFans() {
        return this.mData.bYL;
    }

    public int getMsgBookmark() {
        return this.mData.bYK;
    }

    public void setMsgBookmark(int i) {
        this.mData.bYK = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bYM;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bYM = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.chh = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.chh;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.chi = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.chi;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.chj = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.chj;
    }
}
