package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int biZ = 0;
        private int bja = 0;
        private int bjb = 0;
        private int bjc = 0;
        private int bje = 0;
        private int bjd = 0;
        private int bjf = 0;
        private int bri = 0;
        private int brj = 0;
        private int brk = 0;

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
        this.mData.biZ = i;
        this.mData.bja = i2;
        this.mData.bjb = i3;
        this.mData.bjc = i4;
        this.mData.bjd = i5;
        this.mData.bjf = i6;
        this.mData.bri = i7;
    }

    public int getMsgAgree() {
        return this.mData.biZ;
    }

    public void setMsgAgree(int i) {
        this.mData.biZ = i;
    }

    public int getMsgReplyme() {
        return this.mData.bja;
    }

    public void setMsgReplyme(int i) {
        this.mData.bja = i;
    }

    public int getMsgAtme() {
        return this.mData.bjb;
    }

    public void setMsgAtme(int i) {
        this.mData.bjb = i;
    }

    public int getMsgChat() {
        return this.mData.bjc;
    }

    public void setMsgChat(int i) {
        this.mData.bjc = i;
    }

    public void setMsgFans(int i) {
        this.mData.bje = i;
    }

    public int getMsgFans() {
        return this.mData.bje;
    }

    public int getMsgBookmark() {
        return this.mData.bjd;
    }

    public void setMsgBookmark(int i) {
        this.mData.bjd = i;
    }

    public int getMsgGiftNum() {
        return this.mData.bjf;
    }

    public void setMsgGiftNum(int i) {
        this.mData.bjf = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.bri = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.bri;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.brj = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.brj;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.brk = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.brk;
    }
}
