package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    /* loaded from: classes.dex */
    public class a {
        private int aCF = 0;
        private int aCG = 0;
        private int aCH = 0;
        private int aCI = 0;
        private int aCK = 0;
        private int aCJ = 0;
        private int aCL = 0;
        private int aJT = 0;
        private int aJU = 0;
        private int aJV = 0;

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
        this.mData.aCF = i;
        this.mData.aCG = i2;
        this.mData.aCH = i3;
        this.mData.aCI = i4;
        this.mData.aCJ = i5;
        this.mData.aCL = i6;
        this.mData.aJT = i7;
    }

    public int getMsgAgree() {
        return this.mData.aCF;
    }

    public void setMsgAgree(int i) {
        this.mData.aCF = i;
    }

    public int getMsgReplyme() {
        return this.mData.aCG;
    }

    public void setMsgReplyme(int i) {
        this.mData.aCG = i;
    }

    public int getMsgAtme() {
        return this.mData.aCH;
    }

    public void setMsgAtme(int i) {
        this.mData.aCH = i;
    }

    public int getMsgChat() {
        return this.mData.aCI;
    }

    public void setMsgChat(int i) {
        this.mData.aCI = i;
    }

    public void setMsgFans(int i) {
        this.mData.aCK = i;
    }

    public int getMsgFans() {
        return this.mData.aCK;
    }

    public int getMsgBookmark() {
        return this.mData.aCJ;
    }

    public void setMsgBookmark(int i) {
        this.mData.aCJ = i;
    }

    public int getMsgGiftNum() {
        return this.mData.aCL;
    }

    public void setMsgGiftNum(int i) {
        this.mData.aCL = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aJT = i;
    }

    public int getMsgPrivateChat() {
        return this.mData.aJT;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aJU = i;
    }

    public int getMsgStrangerChat() {
        return this.mData.aJU;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.aJV = i;
    }

    public int getMsgOfficialMerge() {
        return this.mData.aJV;
    }
}
