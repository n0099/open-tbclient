package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13812a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f13813b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f13814c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13815d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13816e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13817f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13818g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f13819h = 0;
        public int i = 0;
        public int j = 0;

        public a(NewsNotifyMessage newsNotifyMessage) {
        }
    }

    public NewsNotifyMessage() {
        super(2001120);
        this.mData = new a(this);
    }

    public int getMsgAgree() {
        return this.mData.f13812a;
    }

    public int getMsgAtme() {
        return this.mData.f13814c;
    }

    public int getMsgBookmark() {
        return this.mData.f13817f;
    }

    public int getMsgChat() {
        return this.mData.f13815d;
    }

    public int getMsgFans() {
        return this.mData.f13816e;
    }

    public int getMsgGiftNum() {
        return this.mData.f13818g;
    }

    public int getMsgOfficialMerge() {
        return this.mData.j;
    }

    public int getMsgPrivateChat() {
        return this.mData.f13819h;
    }

    public int getMsgReplyme() {
        return this.mData.f13813b;
    }

    public int getMsgStrangerChat() {
        return this.mData.i;
    }

    public void setMsgAgree(int i) {
        this.mData.f13812a = i;
    }

    public void setMsgAtme(int i) {
        this.mData.f13814c = i;
    }

    public void setMsgBookmark(int i) {
        this.mData.f13817f = i;
    }

    public void setMsgChat(int i) {
        this.mData.f13815d = i;
    }

    public void setMsgFans(int i) {
        this.mData.f13816e = i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.f13818g = i;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.j = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.f13819h = i;
    }

    public void setMsgReplyme(int i) {
        this.mData.f13813b = i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.i = i;
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(2001120);
        a aVar = new a(this);
        this.mData = aVar;
        aVar.f13812a = i;
        this.mData.f13813b = i2;
        this.mData.f13814c = i3;
        this.mData.f13815d = i4;
        this.mData.f13817f = i5;
        this.mData.f13818g = i6;
        this.mData.f13819h = i7;
    }
}
