package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private b mData;

    public NewsNotifyMessage() {
        super(2001124);
        this.mData = new b(this);
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5) {
        super(2001124);
        this.mData = new b(this);
        this.mData.Ln = i;
        this.mData.Lo = i2;
        this.mData.Lp = i3;
        this.mData.Lq = i4;
        this.mData.Ls = i5;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.Ln;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.Ln = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.Lo;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.Lo = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.Lp;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.Lp = i;
    }

    public void setMsgFans(int i) {
        this.mData.Lr = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.Lr;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.Lq;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.Lq = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.Ls;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.Ls = i;
    }
}
