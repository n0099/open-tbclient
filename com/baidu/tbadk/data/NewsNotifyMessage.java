package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aPv = 0;
        private int aPw = 0;
        private int aPx = 0;
        private int aPy = 0;
        private int aPA = 0;
        private int aPz = 0;
        private int aPB = 0;
        private int aWY = 0;
        private int aWZ = 0;
        private int aXa = 0;

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
        this.mData.aPv = i;
        this.mData.aPw = i2;
        this.mData.aPx = i3;
        this.mData.aPy = i4;
        this.mData.aPz = i5;
        this.mData.aPB = i6;
        this.mData.aWY = i7;
    }

    public int getMsgAgree() {
        return this.mData.aPv;
    }

    public void setMsgAgree(int i) {
        this.mData.aPv = i;
    }

    public int getMsgReplyme() {
        return this.mData.aPw;
    }

    public void setMsgReplyme(int i) {
        this.mData.aPw = i;
    }

    public int getMsgAtme() {
        return this.mData.aPx;
    }

    public void setMsgAtme(int i) {
        this.mData.aPx = i;
    }

    public int getMsgChat() {
        return this.mData.aPy;
    }

    public void setMsgChat(int i) {
        this.mData.aPy = i;
    }

    public void setMsgFans(int i) {
        this.mData.aPA = i;
    }

    public int getMsgFans() {
        return this.mData.aPA;
    }

    public int getMsgBookmark() {
        return this.mData.aPz;
    }

    public void setMsgBookmark(int i) {
        this.mData.aPz = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aPB;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aPB = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aWY = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aWY;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aWZ = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aWZ;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aXa = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aXa;
    }
}
