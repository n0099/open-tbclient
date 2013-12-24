package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.gson.Gson;
import com.baidu.tieba.im.data.UserData;
/* loaded from: classes.dex */
public class a {
    public static PersonalSettingItemData a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        s<String> u = com.baidu.tieba.b.a.a().u();
        com.baidu.adp.lib.h.e.d("key is:" + str3);
        String a = u.a(str3);
        com.baidu.adp.lib.h.e.d("key is:" + str3 + " value is:" + a);
        if (TextUtils.isEmpty(a)) {
            PersonalSettingItemData personalSettingItemData = new PersonalSettingItemData();
            personalSettingItemData.setMyUid(str);
            personalSettingItemData.setToUid(str2);
            personalSettingItemData.setAcceptNotify(true);
            a(personalSettingItemData);
            return personalSettingItemData;
        }
        return (PersonalSettingItemData) new Gson().fromJson(a, (Class<Object>) PersonalSettingItemData.class);
    }

    public static void a(String str, String str2, UserData userData) {
        PersonalSettingItemData a;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (a = a(str, str2)) != null) {
            a.setToPortrait(userData.getPortrait());
            a.setToName(userData.getUserName());
            a(a);
        }
    }

    public static void a(PersonalSettingItemData personalSettingItemData) {
        if (personalSettingItemData == null) {
            com.baidu.adp.lib.h.e.d("value is null");
            return;
        }
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
            com.baidu.adp.lib.h.e.a(" key value is null");
            if (com.baidu.tieba.data.h.u()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        s<String> u = com.baidu.tieba.b.a.a().u();
        String str = myUid + "@" + toUid;
        com.baidu.adp.lib.h.e.d(" key value is " + str);
        String json = new Gson().toJson(personalSettingItemData);
        com.baidu.adp.lib.h.e.d(" json value is " + json);
        u.a(str, json, 315532800000L);
    }

    public static void a(String str, String str2, boolean z) {
        PersonalSettingItemData a = a(str, str2);
        if (a != null) {
            a.setMyUid(str);
            a.setToUid(str2);
            a.setAcceptNotify(z);
            a(a);
        }
    }

    public static boolean b(String str, String str2) {
        PersonalSettingItemData a = a(str, str2);
        if (a == null) {
            return false;
        }
        return a.isAcceptNotify();
    }
}
