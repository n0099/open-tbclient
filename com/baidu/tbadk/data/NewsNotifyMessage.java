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
        this.mData.Rv = i;
        this.mData.Rw = i2;
        this.mData.Rx = i3;
        this.mData.Ry = i4;
        this.mData.RA = i5;
        this.mData.WW = i6;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.Rv;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.Rv = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.Rw;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.Rw = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.Rx;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.Rx = i;
    }

    public void setMsgFans(int i) {
        this.mData.Rz = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.Rz;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.Ry;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.Ry = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.RA;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.RA = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.WW = i;
    }

    public int getMsgPrivateChat() {
        int i;
        i = this.mData.WW;
        return i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.WX = i;
    }

    public int getMsgStrangerChat() {
        int i;
        i = this.mData.WX;
        return i;
    }
}
