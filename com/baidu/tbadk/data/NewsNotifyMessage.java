package com.baidu.tbadk.data;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsNotifyMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13813a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f13814b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f13815c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13816d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13817e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13818f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13819g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f13820h = 0;
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
        return this.mData.f13813a;
    }

    public int getMsgAtme() {
        return this.mData.f13815c;
    }

    public int getMsgBookmark() {
        return this.mData.f13818f;
    }

    public int getMsgChat() {
        return this.mData.f13816d;
    }

    public int getMsgFans() {
        return this.mData.f13817e;
    }

    public int getMsgGiftNum() {
        return this.mData.f13819g;
    }

    public int getMsgOfficialMerge() {
        return this.mData.j;
    }

    public int getMsgPrivateChat() {
        return this.mData.f13820h;
    }

    public int getMsgReplyme() {
        return this.mData.f13814b;
    }

    public int getMsgStrangerChat() {
        return this.mData.i;
    }

    public void setMsgAgree(int i) {
        this.mData.f13813a = i;
    }

    public void setMsgAtme(int i) {
        this.mData.f13815c = i;
    }

    public void setMsgBookmark(int i) {
        this.mData.f13818f = i;
    }

    public void setMsgChat(int i) {
        this.mData.f13816d = i;
    }

    public void setMsgFans(int i) {
        this.mData.f13817e = i;
    }

    public void setMsgGiftNum(int i) {
        this.mData.f13819g = i;
    }

    public void setMsgOfficialMerge(int i) {
        this.mData.j = i;
    }

    public void setMsgPrivateChat(int i) {
        this.mData.f13820h = i;
    }

    public void setMsgReplyme(int i) {
        this.mData.f13814b = i;
    }

    public void setMsgStrangerChat(int i) {
        this.mData.i = i;
    }

    public NewsNotifyMessage(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(2001120);
        a aVar = new a(this);
        this.mData = aVar;
        aVar.f13813a = i;
        this.mData.f13814b = i2;
        this.mData.f13815c = i3;
        this.mData.f13816d = i4;
        this.mData.f13818f = i5;
        this.mData.f13819g = i6;
        this.mData.f13820h = i7;
    }
}
