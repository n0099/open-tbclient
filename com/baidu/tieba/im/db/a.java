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
        cVar.f1665a = b(str);
        cVar.b = c(str);
        cVar.c = d(str);
        return cVar;
    }

    private static boolean b(String str) {
        if (com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.B(), str)) {
            com.baidu.tieba.im.groupInfo.u.a(TiebaApplication.B(), str, false);
            com.baidu.tieba.im.groupInfo.u.c(TiebaApplication.B(), str, false);
            return true;
        }
        return false;
    }

    private static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return true & l.a().a(str, "apply_join_group") & t.a().a(str) & d.a().e(str);
    }

    private static boolean d(String str) {
        com.baidu.tieba.im.pushNotify.a.h().b((RecentChatFriendData) null);
        ConcurrentHashMap<String, ImMessageCenterPojo> b = ad.a().b();
        if (b != null && !TextUtils.isEmpty(str) && b.get(str) != null) {
            b.remove(str);
            return true;
        }
        return false;
    }
}
