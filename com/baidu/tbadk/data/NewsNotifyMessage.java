package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int cgE = 0;
        private int cgF = 0;
        private int cgG = 0;
        private int cgH = 0;
        private int cgJ = 0;
        private int cgI = 0;
        private int cgK = 0;
        private int cpp = 0;
        private int cpq = 0;
        private int cpr = 0;

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
        this.mData.cgE = i;
        this.mData.cgF = i2;
        this.mData.cgG = i3;
        this.mData.cgH = i4;
        this.mData.cgI = i5;
        this.mData.cgK = i6;
        this.mData.cpp = i7;
    }

    public int getMsgAgree() {
        return this.mData.cgE;
    }

    public void setMsgAgree(int i) {
        this.mData.cgE = i;
    }

    public int getMsgReplyme() {
        return this.mData.cgF;
    }

    public void setMsgReplyme(int i) {
        this.mData.cgF = i;
    }

    public int getMsgAtme() {
        return this.mData.cgG;
    }

    public void setMsgAtme(int i) {
        this.mData.cgG = i;
    }

    public int getMsgChat() {
        return this.mData.cgH;
    }

    public void setMsgChat(int i) {
        this.mData.cgH = i;
    }

    public void setMsgFans(int i) {
        this.mData.cgJ = i;
    }

    public int getMsgFans() {
        return this.mData.cgJ;
    }

    public int getMsgBookmark() {
        return this.mData.cgI;
    }

    public void setMsgBookmark(int i) {
        this.mData.cgI = i;
    }

    public int getMsgGiftNum() {
        return this.mData.cgK;
    }

    public void setMsgGiftNum(int i) {
        this.mData.cgK = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.cpp = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.cpp;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.cpq = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.cpq;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.cpr = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.cpr;
    }
}
