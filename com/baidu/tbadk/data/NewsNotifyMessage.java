package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int chQ = 0;
        private int chR = 0;
        private int chS = 0;
        private int chT = 0;
        private int chV = 0;
        private int chU = 0;
        private int chW = 0;
        private int cqJ = 0;
        private int cqK = 0;
        private int cqL = 0;

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
        this.mData.chQ = i;
        this.mData.chR = i2;
        this.mData.chS = i3;
        this.mData.chT = i4;
        this.mData.chU = i5;
        this.mData.chW = i6;
        this.mData.cqJ = i7;
    }

    public int getMsgAgree() {
        return this.mData.chQ;
    }

    public void setMsgAgree(int i) {
        this.mData.chQ = i;
    }

    public int getMsgReplyme() {
        return this.mData.chR;
    }

    public void setMsgReplyme(int i) {
        this.mData.chR = i;
    }

    public int getMsgAtme() {
        return this.mData.chS;
    }

    public void setMsgAtme(int i) {
        this.mData.chS = i;
    }

    public int getMsgChat() {
        return this.mData.chT;
    }

    public void setMsgChat(int i) {
        this.mData.chT = i;
    }

    public void setMsgFans(int i) {
        this.mData.chV = i;
    }

    public int getMsgFans() {
        return this.mData.chV;
    }

    public int getMsgBookmark() {
        return this.mData.chU;
    }

    public void setMsgBookmark(int i) {
        this.mData.chU = i;
    }

    public int getMsgGiftNum() {
        return this.mData.chW;
    }

    public void setMsgGiftNum(int i) {
        this.mData.chW = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.cqJ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.cqJ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.cqK = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.cqK;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.cqL = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.cqL;
    }
}
