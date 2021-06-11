package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12645a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12646b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f12647c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f12648d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f12649e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f12650f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f12651g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12652h = false;

        /* renamed from: i  reason: collision with root package name */
        public int f12653i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f12651g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f12647c;
    }

    public int getMsgAtCount() {
        return this.mData.f12649e;
    }

    public int getMsgCount() {
        return this.mData.f12645a;
    }

    public int getMsgFansCount() {
        return this.mData.f12650f;
    }

    public int getMsgReplyCount() {
        return this.mData.f12648d;
    }

    public int getNotificationCount() {
        return this.mData.f12653i;
    }

    public boolean hasChatRemind() {
        return this.mData.f12652h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f12646b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i2) {
        this.mData.f12651g = i2;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f12652h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f12646b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i2) {
        this.mData.f12647c = i2;
    }

    public void setMsgAtCount(int i2) {
        this.mData.f12649e = i2;
    }

    public void setMsgCount(int i2) {
        this.mData.f12645a = i2;
    }

    public void setMsgFansCount(int i2) {
        this.mData.f12650f = i2;
    }

    public void setMsgReplyCount(int i2) {
        this.mData.f12648d = i2;
    }

    public void setNotificationCount(int i2) {
        this.mData.f12653i = i2;
    }
}
