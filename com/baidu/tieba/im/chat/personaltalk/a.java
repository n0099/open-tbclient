package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.t;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class a {
    private static HashMap<String, String> a = new HashMap<>();

    public static void a() {
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
                s<String> v = com.baidu.tieba.c.a.a().v();
                List<t<String>> a3 = com.baidu.adp.lib.util.i.a(v);
                if (a3 != null) {
                    for (t<String> tVar : a3) {
                        String str3 = tVar.a;
                        if (str3 != null && str3.startsWith(str2) && (a2 = v.a(str3)) != null) {
                            a.put(str3, a2);
                        }
                    }
                }
            }
        }
    }

    public static PersonalSettingItemData a(String str, String str2) {
        String str3;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str4 = String.valueOf(str) + "@" + str2;
        com.baidu.adp.lib.util.e.e("key is:" + str4);
        synchronized (a) {
            str3 = a.get(str4);
        }
        com.baidu.adp.lib.util.e.e("key is:" + str4 + " value is:" + str3);
        if (TextUtils.isEmpty(str3)) {
            PersonalSettingItemData personalSettingItemData = new PersonalSettingItemData();
            personalSettingItemData.setMyUid(str);
            personalSettingItemData.setToUid(str2);
            personalSettingItemData.setAcceptNotify(true);
            a(personalSettingItemData);
            return personalSettingItemData;
        }
        try {
            return (PersonalSettingItemData) new Gson().fromJson(str3, (Class<Object>) PersonalSettingItemData.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public static void a(String str, String str2, UserData userData) {
        PersonalSettingItemData a2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (a2 = a(str, str2)) != null) {
            a2.setToPortrait(userData.getPortrait());
            a2.setToName(userData.getUserName());
            a(a2);
        }
    }

    public static void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData == null) {
            com.baidu.adp.lib.util.e.e("value is null");
            return;
        }
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
            com.baidu.adp.lib.util.e.b(" key value is null");
            if (com.baidu.tieba.data.i.F()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        s<String> v = com.baidu.tieba.c.a.a().v();
        String str = String.valueOf(myUid) + "@" + toUid;
        com.baidu.adp.lib.util.e.e(" key value is " + str);
        String json = new Gson().toJson(personalSettingItemData);
        com.baidu.adp.lib.util.e.e(" json value is " + json);
        synchronized (a) {
            a.put(str, json);
        }
        v.a(str, json);
    }

    public static void a(String str, String str2, boolean z) {
        PersonalSettingItemData a2 = a(str, str2);
        if (a2 != null) {
            a2.setMyUid(str);
            a2.setToUid(str2);
            a2.setAcceptNotify(z);
            a(a2);
        }
    }

    public static boolean b(String str, String str2) {
        PersonalSettingItemData a2 = a(str, str2);
        if (a2 == null) {
            return false;
        }
        return a2.isAcceptNotify();
    }

    public static void a(String str, String str2, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.i.a(new b(str, str2), aVar);
    }
}
