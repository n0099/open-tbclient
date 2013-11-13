package com.baidu.tieba.data.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.m;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c b;
    private long c = 0;

    /* renamed from: a  reason: collision with root package name */
    private final a f1190a = new a();

    private c() {
    }

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    protected long b() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis <= this.c) {
            this.c++;
            return this.c;
        }
        return currentTimeMillis;
    }

    public void a(List<ChatMessageData> list) {
        for (ChatMessageData chatMessageData : list) {
            chatMessageData.setLocalTime(b());
            this.f1190a.a(chatMessageData);
        }
    }

    public List<ChatMessageData> a(String str, String str2) {
        return this.f1190a.a(str, str2, 20);
    }

    public void b(String str, String str2) {
        this.f1190a.a(str, str2);
    }

    public void a(String str, List<RecentChatFriendData> list) {
        this.f1190a.a(str, list);
    }

    public void a(RecentChatFriendData recentChatFriendData) {
        this.f1190a.a(recentChatFriendData);
    }

    public void a(String str, int i, com.baidu.tieba.im.a<Void> aVar) {
        m.a(new d(this, str, i), aVar);
    }

    public void a(String str, int i) {
        RecentChatFriendData b2;
        if (!TextUtils.isEmpty(str) && (b2 = b(str)) != null) {
            b2.setUnReadCount(i);
            a(b2);
        }
    }

    public List<RecentChatFriendData> a(String str) {
        return this.f1190a.a(str, 20);
    }

    public RecentChatFriendData b(String str) {
        LinkedList<RecentChatFriendData> a2 = this.f1190a.a(1, str);
        if (a2 == null || a2.isEmpty()) {
            return null;
        }
        return a2.get(0);
    }

    public void c(String str, String str2) {
        this.f1190a.b(str, str2);
    }
}
