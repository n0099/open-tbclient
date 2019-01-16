package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aQb = 0;
        private int aQc = 0;
        private int aQd = 0;
        private int aQe = 0;
        private int aQg = 0;
        private int aQf = 0;
        private int aQh = 0;
        private int aXJ = 0;
        private int aXK = 0;
        private int aXL = 0;

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
        this.mData.aQb = i;
        this.mData.aQc = i2;
        this.mData.aQd = i3;
        this.mData.aQe = i4;
        this.mData.aQf = i5;
        this.mData.aQh = i6;
        this.mData.aXJ = i7;
    }

    public int getMsgAgree() {
        return this.mData.aQb;
    }

    public void setMsgAgree(int i) {
        this.mData.aQb = i;
    }

    public int getMsgReplyme() {
        return this.mData.aQc;
    }

    public void setMsgReplyme(int i) {
        this.mData.aQc = i;
    }

    public int getMsgAtme() {
        return this.mData.aQd;
    }

    public void setMsgAtme(int i) {
        this.mData.aQd = i;
    }

    public int getMsgChat() {
        return this.mData.aQe;
    }

    public void setMsgChat(int i) {
        this.mData.aQe = i;
    }

    public void setMsgFans(int i) {
        this.mData.aQg = i;
    }

    public int getMsgFans() {
        return this.mData.aQg;
    }

    public int getMsgBookmark() {
        return this.mData.aQf;
    }

    public void setMsgBookmark(int i) {
        this.mData.aQf = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aQh;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aQh = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aXJ = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aXJ;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aXK = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aXK;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aXL = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aXL;
    }
}
