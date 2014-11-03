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
        this.mData.Lq = i;
        this.mData.Lr = i2;
        this.mData.Ls = i3;
        this.mData.Lt = i4;
        this.mData.Lv = i5;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.Lq;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.Lq = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.Lr;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.Lr = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.Ls;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.Ls = i;
    }

    public void setMsgFans(int i) {
        this.mData.Lu = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.Lu;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.Lt;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.Lt = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.Lv;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.Lv = i;
    }
}
