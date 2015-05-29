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
        this.mData.acu = i;
        this.mData.acv = i2;
        this.mData.acw = i3;
        this.mData.acx = i4;
        this.mData.acz = i5;
        this.mData.aii = i6;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.acu;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.acu = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.acv;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.acv = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.acw;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.acw = i;
    }

    public void setMsgFans(int i) {
        this.mData.acy = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.acy;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.acx;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.acx = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.acz;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.acz = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.aii = i;
    }

    public int getMsgPrivateChat() {
        int i;
        i = this.mData.aii;
        return i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aij = i;
    }

    public int getMsgStrangerChat() {
        int i;
        i = this.mData.aij;
        return i;
    }

    public void setMsgLiveVip(int i) {
        this.mData.acA = i;
    }

    public int getMsgLiveVip() {
        int i;
        i = this.mData.acA;
        return i;
    }
}
