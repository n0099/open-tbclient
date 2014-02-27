package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class v {
    private static HashMap<String, String> a = new HashMap<>();

    private static void a() {
        String a2;
        synchronized (a) {
            a.clear();
        }
        String str = "";
        if (TiebaApplication.y() != null) {
            str = TiebaApplication.y().getID();
        }
        if (str != null && str.length() != 0) {
            String str2 = String.valueOf(str) + "@";
            synchronized (a) {
                com.baidu.adp.lib.cache.s<String> u = com.baidu.tieba.c.a.a().u();
                List<com.baidu.adp.lib.cache.t<String>> a3 = com.baidu.adp.lib.util.i.a(u);
                if (a3 != null) {
                    for (com.baidu.adp.lib.cache.t<String> tVar : a3) {
                        String str3 = tVar.a;
                        if (str3 != null && str3.startsWith(str2) && (a2 = u.a(str3)) != null) {
                            a.put(str3, a2);
                        }
                    }
                }
            }
        }
    }

    public static GroupSettingItemData a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str4 = String.valueOf(str) + "@" + str2;
        com.baidu.adp.lib.util.e.e("key is:" + str4);
        synchronized (a) {
            str3 = a.get(str4);
        }
        if (str3 == null && (str3 = com.baidu.tieba.c.a.a().u().a(str4)) != null) {
            a();
        }
        if (TextUtils.isEmpty(str3)) {
            com.baidu.adp.lib.util.e.e("key is:" + str4 + " value is:" + str3);
            GroupSettingItemData groupSettingItemData = new GroupSettingItemData();
            groupSettingItemData.setUid(str);
            groupSettingItemData.setGid(str2);
            groupSettingItemData.setAcceptNotify(true);
            groupSettingItemData.setInGroup(true);
            a(groupSettingItemData);
            return groupSettingItemData;
        }
        try {
            return (GroupSettingItemData) new Gson().fromJson(str3, (Class<Object>) GroupSettingItemData.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(GroupSettingItemData groupSettingItemData) {
        if (groupSettingItemData == null) {
            com.baidu.adp.lib.util.e.e("value is null");
            return;
        }
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
            com.baidu.adp.lib.util.e.b(" key value is null");
            if (com.baidu.tieba.data.i.F()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> u = com.baidu.tieba.c.a.a().u();
        String str = String.valueOf(uid) + "@" + gid;
        com.baidu.adp.lib.util.e.e(" key value is " + str);
        String json = new Gson().toJson(groupSettingItemData);
        com.baidu.adp.lib.util.e.e(" json value is " + json);
        synchronized (a) {
            a.put(str, json);
        }
        u.a(str, json);
    }

    public static void a(String str, String str2, boolean z) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 != null) {
            a2.setAlreadyApply(z);
            a2.setLastApplyTimeStamp(System.currentTimeMillis());
            a(a2);
        }
    }

    public static void b(String str, String str2, boolean z) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 != null) {
            a2.setAcceptNotify(z);
            a(a2);
        }
    }

    public static boolean b(String str, String str2) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 == null) {
            return false;
        }
        return a2.isAcceptNotify();
    }

    public static void c(String str, String str2, boolean z) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 != null) {
            a2.setInGroup(z);
            a(a2);
        }
    }

    public static void d(String str, String str2, boolean z) {
        new w(str, str2, z).execute(new Void[0]);
    }

    public static boolean c(String str, String str2) {
        GroupSettingItemData a2 = a(str, str2);
        if (a2 == null) {
            return false;
        }
        com.baidu.adp.lib.util.e.e("uid:" + str + " gid:" + str2 + "is in" + a2.isInGroup());
        return a2.isInGroup();
    }

    public static void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.i.a(new x(str, str2, 60000L), aVar);
    }
}
