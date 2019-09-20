package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int ciM = 0;
        private int ciN = 0;
        private int ciO = 0;
        private int ciP = 0;
        private int ciR = 0;
        private int ciQ = 0;
        private int ciS = 0;
        private int crE = 0;
        private int crF = 0;
        private int crG = 0;

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
        this.mData.ciM = i;
        this.mData.ciN = i2;
        this.mData.ciO = i3;
        this.mData.ciP = i4;
        this.mData.ciQ = i5;
        this.mData.ciS = i6;
        this.mData.crE = i7;
    }

    public int getMsgAgree() {
        return this.mData.ciM;
    }

    public void setMsgAgree(int i) {
        this.mData.ciM = i;
    }

    public int getMsgReplyme() {
        return this.mData.ciN;
    }

    public void setMsgReplyme(int i) {
        this.mData.ciN = i;
    }

    public int getMsgAtme() {
        return this.mData.ciO;
    }

    public void setMsgAtme(int i) {
        this.mData.ciO = i;
    }

    public int getMsgChat() {
        return this.mData.ciP;
    }

    public void setMsgChat(int i) {
        this.mData.ciP = i;
    }

    public void setMsgFans(int i) {
        this.mData.ciR = i;
    }

    public int getMsgFans() {
        return this.mData.ciR;
    }

    public int getMsgBookmark() {
        return this.mData.ciQ;
    }

    public void setMsgBookmark(int i) {
        this.mData.ciQ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.ciS;
    }

    public void setMsgGiftNum(int i) {
        this.mData.ciS = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.crE = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.crE;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.crF = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.crF;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.crG = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.crG;
    }
}
