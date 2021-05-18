package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f12675a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f12676b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f12677c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f12678d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f12679e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f12680f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f12681g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f12682h = false;

        /* renamed from: i  reason: collision with root package name */
        public int f12683i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f12681g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f12677c;
    }

    public int getMsgAtCount() {
        return this.mData.f12679e;
    }

    public int getMsgCount() {
        return this.mData.f12675a;
    }

    public int getMsgFansCount() {
        return this.mData.f12680f;
    }

    public int getMsgReplyCount() {
        return this.mData.f12678d;
    }

    public int getNotificationCount() {
        return this.mData.f12683i;
    }

    public boolean hasChatRemind() {
        return this.mData.f12682h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f12676b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i2) {
        this.mData.f12681g = i2;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f12682h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f12676b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i2) {
        this.mData.f12677c = i2;
    }

    public void setMsgAtCount(int i2) {
        this.mData.f12679e = i2;
    }

    public void setMsgCount(int i2) {
        this.mData.f12675a = i2;
    }

    public void setMsgFansCount(int i2) {
        this.mData.f12680f = i2;
    }

    public void setMsgReplyCount(int i2) {
        this.mData.f12678d = i2;
    }

    public void setNotificationCount(int i2) {
        this.mData.f12683i = i2;
    }
}
