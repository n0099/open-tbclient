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
        this.mData.QS = i;
        this.mData.QT = i2;
        this.mData.QU = i3;
        this.mData.QV = i4;
        this.mData.QX = i5;
        this.mData.Wr = i6;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.QS;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.QS = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.QT;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.QT = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.QU;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.QU = i;
    }

    public void setMsgFans(int i) {
        this.mData.QW = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.QW;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.QV;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.QV = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.QX;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.QX = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.Wr = i;
    }

    public int getMsgPrivateChat() {
        int i;
        i = this.mData.Wr;
        return i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.Ws = i;
    }

    public int getMsgStrangerChat() {
        int i;
        i = this.mData.Ws;
        return i;
    }
}
