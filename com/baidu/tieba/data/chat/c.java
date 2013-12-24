package com.baidu.tieba.data.chat;

import android.text.TextUtils;
import com.baidu.tieba.im.m;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c b;
    private long c = 0;
    private final a a = new a();

    private c() {
    }

    public static c a() {
        if (b == null) {
            b = new c();
        }
        return b;
    }

    public void a(RecentChatFriendData recentChatFriendData) {
        this.a.a(recentChatFriendData);
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
        return this.a.a(str, 20);
    }

    public RecentChatFriendData b(String str) {
        LinkedList<RecentChatFriendData> a = this.a.a(1, str);
        if (a == null || a.isEmpty()) {
            return null;
        }
        return a.get(0);
    }

    public void a(String str, String str2) {
        this.a.a(str, str2);
    }
}
