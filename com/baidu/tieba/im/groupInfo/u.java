package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.gson.Gson;
/* loaded from: classes.dex */
public class u {
    public static GroupSettingItemData a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        com.baidu.adp.lib.cache.s<String> t = com.baidu.tieba.b.a.a().t();
        com.baidu.adp.lib.h.e.d("key is:" + str3);
        String a = t.a(str3);
        if (TextUtils.isEmpty(a)) {
            com.baidu.adp.lib.h.e.d("key is:" + str3 + " value is:" + a);
            GroupSettingItemData groupSettingItemData = new GroupSettingItemData();
            groupSettingItemData.setUid(str);
            groupSettingItemData.setGid(str2);
            groupSettingItemData.setAcceptNotify(true);
            groupSettingItemData.setInGroup(true);
            a(groupSettingItemData);
            return groupSettingItemData;
        }
        return (GroupSettingItemData) new Gson().fromJson(a, (Class<Object>) GroupSettingItemData.class);
    }

    public static void a(GroupSettingItemData groupSettingItemData) {
        if (groupSettingItemData == null) {
            com.baidu.adp.lib.h.e.d("value is null");
            return;
        }
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
            com.baidu.adp.lib.h.e.a(" key value is null");
            if (com.baidu.tieba.data.h.u()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> t = com.baidu.tieba.b.a.a().t();
        String str = uid + "@" + gid;
        com.baidu.adp.lib.h.e.d(" key value is " + str);
        String json = new Gson().toJson(groupSettingItemData);
        com.baidu.adp.lib.h.e.d(" json value is " + json);
        t.a(str, json, 315532800000L);
    }

    public static void a(String str, String str2, boolean z) {
        GroupSettingItemData a = a(str, str2);
        if (a != null) {
            a.setAlreadyApply(z);
            a.setLastApplyTimeStamp(System.currentTimeMillis());
            a(a);
        }
    }

    public static void b(String str, String str2, boolean z) {
        GroupSettingItemData a = a(str, str2);
        if (a != null) {
            a.setAcceptNotify(z);
            a(a);
        }
    }

    public static boolean b(String str, String str2) {
        GroupSettingItemData a = a(str, str2);
        if (a == null) {
            return false;
        }
        return a.isAcceptNotify();
    }

    public static void c(String str, String str2, boolean z) {
        GroupSettingItemData a = a(str, str2);
        if (a != null) {
            a.setInGroup(z);
            a(a);
        }
    }

    public static void d(String str, String str2, boolean z) {
        new v(str, str2, z).execute(new Void[0]);
    }

    public static boolean c(String str, String str2) {
        GroupSettingItemData a = a(str, str2);
        if (a == null) {
            return false;
        }
        com.baidu.adp.lib.h.e.d("uid:" + str + " gid:" + str2 + "is in" + a.isInGroup());
        return a.isInGroup();
    }

    public static void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new w(str, str2, j), aVar);
    }
}
