package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private f mData;

    public NewsNotifyMessage() {
        super(2001124);
        this.mData = new f(this);
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6) {
        super(2001124);
        this.mData = new f(this);
        this.mData.abp = i;
        this.mData.abq = i2;
        this.mData.abr = i3;
        this.mData.abt = i4;
        this.mData.abv = i5;
        this.mData.ahh = i6;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.abp;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.abp = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.abq;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.abq = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.abr;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.abr = i;
    }

    public void setMsgFans(int i) {
        this.mData.abu = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.abu;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.abt;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.abt = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.abv;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.abv = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.ahh = i;
    }

    public int getMsgPrivateChat() {
        int i;
        i = this.mData.ahh;
        return i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.ahi = i;
    }

    public int getMsgStrangerChat() {
        int i;
        i = this.mData.ahi;
        return i;
    }
}
