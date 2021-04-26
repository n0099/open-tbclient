package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13339a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13340b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f13341c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13342d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13343e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13344f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13345g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f13346h = false;

        /* renamed from: i  reason: collision with root package name */
        public int f13347i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f13345g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f13341c;
    }

    public int getMsgAtCount() {
        return this.mData.f13343e;
    }

    public int getMsgCount() {
        return this.mData.f13339a;
    }

    public int getMsgFansCount() {
        return this.mData.f13344f;
    }

    public int getMsgReplyCount() {
        return this.mData.f13342d;
    }

    public int getNotificationCount() {
        return this.mData.f13347i;
    }

    public boolean hasChatRemind() {
        return this.mData.f13346h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f13340b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i2) {
        this.mData.f13345g = i2;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f13346h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f13340b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i2) {
        this.mData.f13341c = i2;
    }

    public void setMsgAtCount(int i2) {
        this.mData.f13343e = i2;
    }

    public void setMsgCount(int i2) {
        this.mData.f13339a = i2;
    }

    public void setMsgFansCount(int i2) {
        this.mData.f13344f = i2;
    }

    public void setMsgReplyCount(int i2) {
        this.mData.f13342d = i2;
    }

    public void setNotificationCount(int i2) {
        this.mData.f13347i = i2;
    }
}
