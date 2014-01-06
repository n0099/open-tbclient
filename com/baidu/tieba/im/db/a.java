package com.baidu.tieba.im.db;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.chat.RecentChatFriendData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {
    public static void a(String str, com.baidu.tieba.im.a<c> aVar) {
        com.baidu.tieba.im.m.a(new b(str), aVar);
    }

    public static c a(String str) {
        c cVar = new c();
        cVar.a = c(str);
        cVar.b = d(str);
        cVar.c = b(str);
        return cVar;
    }

    private static boolean c(String str) {
        if (com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.A(), str)) {
            com.baidu.tieba.im.groupInfo.u.a(TiebaApplication.A(), str, false);
            com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.A(), str, false);
            return true;
        }
        return false;
    }

    private static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true & l.a().a(str, "apply_join_group") & t.a().a(str) & d.a().e(str);
    }

    public static boolean b(String str) {
        com.baidu.tieba.im.c.a.h().b((RecentChatFriendData) null);
        ConcurrentHashMap<String, ImMessageCenterPojo> b = ad.a().b();
        if (b != null && !TextUtils.isEmpty(str) && b.get(str) != null) {
            b.remove(str);
            return true;
        }
        return false;
    }
}
