package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int chJ = 0;
        private int chK = 0;
        private int chL = 0;
        private int chM = 0;
        private int chO = 0;
        private int chN = 0;
        private int chP = 0;
        private int cqC = 0;
        private int cqD = 0;
        private int cqE = 0;

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
        this.mData.chJ = i;
        this.mData.chK = i2;
        this.mData.chL = i3;
        this.mData.chM = i4;
        this.mData.chN = i5;
        this.mData.chP = i6;
        this.mData.cqC = i7;
    }

    public int getMsgAgree() {
        return this.mData.chJ;
    }

    public void setMsgAgree(int i) {
        this.mData.chJ = i;
    }

    public int getMsgReplyme() {
        return this.mData.chK;
    }

    public void setMsgReplyme(int i) {
        this.mData.chK = i;
    }

    public int getMsgAtme() {
        return this.mData.chL;
    }

    public void setMsgAtme(int i) {
        this.mData.chL = i;
    }

    public int getMsgChat() {
        return this.mData.chM;
    }

    public void setMsgChat(int i) {
        this.mData.chM = i;
    }

    public void setMsgFans(int i) {
        this.mData.chO = i;
    }

    public int getMsgFans() {
        return this.mData.chO;
    }

    public int getMsgBookmark() {
        return this.mData.chN;
    }

    public void setMsgBookmark(int i) {
        this.mData.chN = i;
    }

    public int getMsgGiftNum() {
        return this.mData.chP;
    }

    public void setMsgGiftNum(int i) {
        this.mData.chP = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.cqC = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.cqC;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.cqD = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.cqD;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.cqE = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.cqE;
    }
}
