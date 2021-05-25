package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12583a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12584b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f12585c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f12586d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f12587e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f12588f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f12589g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12590h = false;

        /* renamed from: i  reason: collision with root package name */
        public int f12591i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f12589g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f12585c;
    }

    public int getMsgAtCount() {
        return this.mData.f12587e;
    }

    public int getMsgCount() {
        return this.mData.f12583a;
    }

    public int getMsgFansCount() {
        return this.mData.f12588f;
    }

    public int getMsgReplyCount() {
        return this.mData.f12586d;
    }

    public int getNotificationCount() {
        return this.mData.f12591i;
    }

    public boolean hasChatRemind() {
        return this.mData.f12590h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f12584b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i2) {
        this.mData.f12589g = i2;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f12590h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f12584b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i2) {
        this.mData.f12585c = i2;
    }

    public void setMsgAtCount(int i2) {
        this.mData.f12587e = i2;
    }

    public void setMsgCount(int i2) {
        this.mData.f12583a = i2;
    }

    public void setMsgFansCount(int i2) {
        this.mData.f12588f = i2;
    }

    public void setMsgReplyCount(int i2) {
        this.mData.f12586d = i2;
    }

    public void setNotificationCount(int i2) {
        this.mData.f12591i = i2;
    }
}
