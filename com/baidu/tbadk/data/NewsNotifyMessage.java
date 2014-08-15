package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    private a mData;

    public NewsNotifyMessage() {
        super(2001124);
        this.mData = new a(this);
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4) {
        super(2001124);
        this.mData = new a(this);
        this.mData.b = i;
        this.mData.c = i2;
        this.mData.d = i3;
        this.mData.f = i4;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.b;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.b = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.c;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.c = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.d;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.d = i;
    }

    public void setMsgFans(int i) {
        this.mData.e = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.e;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.f;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.f = i;
    }
}
