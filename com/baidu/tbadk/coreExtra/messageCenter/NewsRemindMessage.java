package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes3.dex */
public class NewsRemindMessage extends CustomResponsedMessage<Object> {
    public a mData;

    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f13370a = 0;

        /* renamed from: b  reason: collision with root package name */
        public boolean f13371b = false;

        /* renamed from: c  reason: collision with root package name */
        public int f13372c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f13373d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f13374e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f13375f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f13376g = 0;

        /* renamed from: h  reason: collision with root package name */
        public boolean f13377h = false;
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
        return this.mData.f13376g;
    }

    public int getMsgAgreeCount() {
        return this.mData.f13372c;
    }

    public int getMsgAtCount() {
        return this.mData.f13374e;
    }

    public int getMsgCount() {
        return this.mData.f13370a;
    }

    public int getMsgFansCount() {
        return this.mData.f13375f;
    }

    public int getMsgReplyCount() {
        return this.mData.f13373d;
    }

    public int getNotificationCount() {
        return this.mData.i;
    }

    public boolean hasChatRemind() {
        return this.mData.f13377h;
    }

    public boolean hasMsgRemind() {
        return this.mData.f13371b;
    }

    public boolean hasNotificationRemind() {
        return this.mData.j;
    }

    public void setChatCount(int i) {
        this.mData.f13376g = i;
    }

    public void setHasChatRemind(boolean z) {
        this.mData.f13377h = z;
    }

    public void setHasMsgRemind(boolean z) {
        this.mData.f13371b = z;
    }

    public void setHasNotificationRemind(boolean z) {
        this.mData.j = z;
    }

    public void setMsgAgreeCount(int i) {
        this.mData.f13372c = i;
    }

    public void setMsgAtCount(int i) {
        this.mData.f13374e = i;
    }

    public void setMsgCount(int i) {
        this.mData.f13370a = i;
    }

    public void setMsgFansCount(int i) {
        this.mData.f13375f = i;
    }

    public void setMsgReplyCount(int i) {
        this.mData.f13373d = i;
    }

    public void setNotificationCount(int i) {
        this.mData.i = i;
    }
}
