package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12727a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12728b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f12729c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f12730d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f12731e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f12732f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f12733g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12734h = false;

        /* renamed from: i  reason: collision with root package name */
        public int f12735i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f12733g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f12729c;
    }

    public int getMsgAtCount() {
        return this.mData.f12731e;
    }

    public int getMsgCount() {
        return this.mData.f12727a;
    }

    public int getMsgFansCount() {
        return this.mData.f12732f;
    }

    public int getMsgReplyCount() {
        return this.mData.f12730d;
    }

    public int getNotificationCount() {
        return this.mData.f12735i;
    }

    public boolean hasChatRemind() {
        return this.mData.f12734h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f12728b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i2) {
        this.mData.f12733g = i2;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f12734h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f12728b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i2) {
        this.mData.f12729c = i2;
    }

    public void setMsgAtCount(int i2) {
        this.mData.f12731e = i2;
    }

    public void setMsgCount(int i2) {
        this.mData.f12727a = i2;
    }

    public void setMsgFansCount(int i2) {
        this.mData.f12732f = i2;
    }

    public void setMsgReplyCount(int i2) {
        this.mData.f12730d = i2;
    }

    public void setNotificationCount(int i2) {
        this.mData.f12735i = i2;
    }
}
