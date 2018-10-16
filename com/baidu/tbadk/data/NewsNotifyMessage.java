package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aLg = 0;
        private int aLh = 0;
        private int aLi = 0;
        private int aLj = 0;
        private int aLl = 0;
        private int aLk = 0;
        private int aLm = 0;
        private int aSL = 0;
        private int aSM = 0;
        private int aSN = 0;

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
        this.mData.aLg = i;
        this.mData.aLh = i2;
        this.mData.aLi = i3;
        this.mData.aLj = i4;
        this.mData.aLk = i5;
        this.mData.aLm = i6;
        this.mData.aSL = i7;
    }

    public int getMsgAgree() {
        return this.mData.aLg;
    }

    public void setMsgAgree(int i) {
        this.mData.aLg = i;
    }

    public int getMsgReplyme() {
        return this.mData.aLh;
    }

    public void setMsgReplyme(int i) {
        this.mData.aLh = i;
    }

    public int getMsgAtme() {
        return this.mData.aLi;
    }

    public void setMsgAtme(int i) {
        this.mData.aLi = i;
    }

    public int getMsgChat() {
        return this.mData.aLj;
    }

    public void setMsgChat(int i) {
        this.mData.aLj = i;
    }

    public void setMsgFans(int i) {
        this.mData.aLl = i;
    }

    public int getMsgFans() {
        return this.mData.aLl;
    }

    public int getMsgBookmark() {
        return this.mData.aLk;
    }

    public void setMsgBookmark(int i) {
        this.mData.aLk = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aLm;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aLm = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aSL = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aSL;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aSM = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aSM;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aSN = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aSN;
    }
}
