package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.cache.t;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.UserData;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private static HashMap<String, String> a = new HashMap<>();

    public static void a() {
        String a2;
        synchronized (a) {
            a.clear();
        }
        String str = "";
        if (TiebaApplication.E() != null) {
            str = TiebaApplication.E().getID();
        }
        if (str != null && str.length() != 0) {
            String str2 = str + "@";
            synchronized (a) {
                s<String> u = com.baidu.tieba.b.a.a().u();
                List<t<String>> a3 = com.baidu.adp.lib.g.j.a(u);
                if (a3 != null) {
                    for (t<String> tVar : a3) {
                        String str3 = tVar.a;
                        if (str3.startsWith(str2) && (a2 = u.a(str3)) != null) {
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
        String str4 = str + "@" + str2;
        com.baidu.adp.lib.g.e.d("key is:" + str4);
        synchronized (a) {
            str3 = a.get(str4);
        }
        if (str3 == null && (str3 = com.baidu.tieba.b.a.a().u().a(str4)) != null) {
            a();
        }
        com.baidu.adp.lib.g.e.d("key is:" + str4 + " value is:" + str3);
        if (TextUtils.isEmpty(str3)) {
            PersonalSettingItemData personalSettingItemData = new PersonalSettingItemData();
            personalSettingItemData.setMyUid(str);
            personalSettingItemData.setToUid(str2);
            personalSettingItemData.setAcceptNotify(true);
            a(personalSettingItemData);
            return personalSettingItemData;
        }
        return (PersonalSettingItemData) new Gson().fromJson(str3, (Class<Object>) PersonalSettingItemData.class);
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
            com.baidu.adp.lib.g.e.d("value is null");
            return;
        }
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
            com.baidu.adp.lib.g.e.a(" key value is null");
            if (com.baidu.tieba.data.h.u()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        s<String> u = com.baidu.tieba.b.a.a().u();
        String str = myUid + "@" + toUid;
        com.baidu.adp.lib.g.e.d(" key value is " + str);
        String json = new Gson().toJson(personalSettingItemData);
        com.baidu.adp.lib.g.e.d(" json value is " + json);
        synchronized (a) {
            a.put(str, json);
        }
        u.a(str, json);
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
        com.baidu.tieba.im.m.a(new b(str, str2), aVar);
    }
}
