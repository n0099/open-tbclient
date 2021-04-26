package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13464a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f13465b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f13466c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13467d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13468e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13469f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13470g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f13471h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f13472i = 0;
        public int j = 0;

        public a(NewsNotifyMessage newsNotifyMessage) {
        }
    }

    public NewsNotifyMessage() {
        super(2001120);
        this.mData = new a(this);
    }

    public int getMsgAgree() {
        return this.mData.f13464a;
    }

    public int getMsgAtme() {
        return this.mData.f13466c;
    }

    public int getMsgBookmark() {
        return this.mData.f13469f;
    }

    public int getMsgChat() {
        return this.mData.f13467d;
    }

    public int getMsgFans() {
        return this.mData.f13468e;
    }

    public int getMsgGiftNum() {
        return this.mData.f13470g;
    }

    public int getMsgOfficialMerge() {
        return this.mData.j;
    }

    public int getMsgPrivateChat() {
        return this.mData.f13471h;
    }

    public int getMsgReplyme() {
        return this.mData.f13465b;
    }

    public int getMsgStrangerChat() {
        return this.mData.f13472i;
    }

    public void setMsgAgree(int i2) {
        this.mData.f13464a = i2;
    }

    public void setMsgAtme(int i2) {
        this.mData.f13466c = i2;
    }

    public void setMsgBookmark(int i2) {
        this.mData.f13469f = i2;
    }

    public void setMsgChat(int i2) {
        this.mData.f13467d = i2;
    }

    public void setMsgFans(int i2) {
        this.mData.f13468e = i2;
    }

    public void setMsgGiftNum(int i2) {
        this.mData.f13470g = i2;
    }

    public void setMsgOfficialMerge(int i2) {
        this.mData.j = i2;
    }

    public void setMsgPrivateChat(int i2) {
        this.mData.f13471h = i2;
    }

    public void setMsgReplyme(int i2) {
        this.mData.f13465b = i2;
    }

    public void setMsgStrangerChat(int i2) {
        this.mData.f13472i = i2;
    }

    public NewsNotifyMessage(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        super(2001120);
        a aVar = new a(this);
        this.mData = aVar;
        aVar.f13464a = i2;
        this.mData.f13465b = i3;
        this.mData.f13466c = i4;
        this.mData.f13467d = i5;
        this.mData.f13469f = i6;
        this.mData.f13470g = i7;
        this.mData.f13471h = i8;
    }
}
