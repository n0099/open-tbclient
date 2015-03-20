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
        this.mData.abh = i;
        this.mData.abi = i2;
        this.mData.abj = i3;
        this.mData.abk = i4;
        this.mData.abm = i5;
        this.mData.agZ = i6;
    }

    public int getMsgReplyme() {
        int i;
        i = this.mData.abh;
        return i;
    }

    public void setMsgReplyme(int i) {
        this.mData.abh = i;
    }

    public int getMsgAtme() {
        int i;
        i = this.mData.abi;
        return i;
    }

    public void setMsgAtme(int i) {
        this.mData.abi = i;
    }

    public int getMsgChat() {
        int i;
        i = this.mData.abj;
        return i;
    }

    public void setMsgChat(int i) {
        this.mData.abj = i;
    }

    public void setMsgFans(int i) {
        this.mData.abl = i;
    }

    public int getMsgFans() {
        int i;
        i = this.mData.abl;
        return i;
    }

    public int getMsgBookmark() {
        int i;
        i = this.mData.abk;
        return i;
    }

    public void setMsgBookmark(int i) {
        this.mData.abk = i;
    }

    public int getMsgGiftNum() {
        int i;
        i = this.mData.abm;
        return i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.abm = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.agZ = i;
    }

    public int getMsgPrivateChat() {
        int i;
        i = this.mData.agZ;
        return i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.aha = i;
    }

    public int getMsgStrangerChat() {
        int i;
        i = this.mData.aha;
        return i;
    }
}
