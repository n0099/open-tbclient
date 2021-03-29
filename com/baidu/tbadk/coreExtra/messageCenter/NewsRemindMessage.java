package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13701a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13702b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f13703c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13704d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13705e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13706f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13707g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f13708h = false;
        public int i = 0;
        public boolean j = false;

        public a(NewsRemindMessage newsRemindMessage) {
        }
    }

    public NewsRemindMessage() {
        super(2001626);
        this.mData = new a(this);
    }

    public int getChatCount() {
        return this.mData.f13707g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f13703c;
    }

    public int getMsgAtCount() {
        return this.mData.f13705e;
    }

    public int getMsgCount() {
        return this.mData.f13701a;
    }

    public int getMsgFansCount() {
        return this.mData.f13706f;
    }

    public int getMsgReplyCount() {
        return this.mData.f13704d;
    }

    public int getNotificationCount() {
        return this.mData.i;
    }

    public boolean hasChatRemind() {
        return this.mData.f13708h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f13702b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i) {
        this.mData.f13707g = i;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f13708h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f13702b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.f13703c = i;
    }

    public void setMsgAtCount(int i) {
        this.mData.f13705e = i;
    }

    public void setMsgCount(int i) {
        this.mData.f13701a = i;
    }

    public void setMsgFansCount(int i) {
        this.mData.f13706f = i;
    }

    public void setMsgReplyCount(int i) {
        this.mData.f13704d = i;
    }

    public void setNotificationCount(int i) {
        this.mData.i = i;
    }
}
