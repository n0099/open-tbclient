package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int auu = 0;
        private int auv = 0;
        private int auw = 0;
        private int aux = 0;
        private int auz = 0;
        private int auy = 0;
        private int auA = 0;
        private int aBy = 0;
        private int aBz = 0;
        private int aBA = 0;

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
        this.mData.auu = i;
        this.mData.auv = i2;
        this.mData.auw = i3;
        this.mData.aux = i4;
        this.mData.auy = i5;
        this.mData.auA = i6;
        this.mData.aBy = i7;
    }

    public int getMsgAgree() {
        return this.mData.auu;
    }

    public void setMsgAgree(int i) {
        this.mData.auu = i;
    }

    public int getMsgReplyme() {
        return this.mData.auv;
    }

    public void setMsgReplyme(int i) {
        this.mData.auv = i;
    }

    public int getMsgAtme() {
        return this.mData.auw;
    }

    public void setMsgAtme(int i) {
        this.mData.auw = i;
    }

    public int getMsgChat() {
        return this.mData.aux;
    }

    public void setMsgChat(int i) {
        this.mData.aux = i;
    }

    public void setMsgFans(int i) {
        this.mData.auz = i;
    }

    public int getMsgFans() {
        return this.mData.auz;
    }

    public int getMsgBookmark() {
        return this.mData.auy;
    }

    public void setMsgBookmark(int i) {
        this.mData.auy = i;
    }

    public int getMsgGiftNum() {
        return this.mData.auA;
    }

    public void setMsgGiftNum(int i) {
        this.mData.auA = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aBy = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aBy;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aBz = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aBz;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aBA = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aBA;
    }
}
