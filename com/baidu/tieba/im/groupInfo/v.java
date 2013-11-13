package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.google.gson.Gson;
/* loaded from: classes.dex */
public class v {
    public static GroupSettingItemData a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        com.baidu.adp.lib.cache.s<String> p = com.baidu.tieba.b.a.a().p();
        com.baidu.adp.lib.h.d.d("key is:" + str3);
        String a2 = p.a(str3);
        if (TextUtils.isEmpty(a2)) {
            com.baidu.adp.lib.h.d.d("key is:" + str3 + " value is:" + a2);
            GroupSettingItemData groupSettingItemData = new GroupSettingItemData();
            groupSettingItemData.setUid(str);
            groupSettingItemData.setGid(str2);
            groupSettingItemData.setAcceptNotify(true);
            groupSettingItemData.setInGroup(true);
            a(groupSettingItemData);
            return groupSettingItemData;
        }
        return (GroupSettingItemData) new Gson().fromJson(a2, (Class<Object>) GroupSettingItemData.class);
    }

    public static void a(GroupSettingItemData groupSettingItemData) {
        if (groupSettingItemData == null) {
            com.baidu.adp.lib.h.d.d("value is null");
            return;
        }
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
            com.baidu.adp.lib.h.d.a(" key value is null");
            if (com.baidu.tieba.data.h.s()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> p = com.baidu.tieba.b.a.a().p();
        String str = uid + "@" + gid;
        com.baidu.adp.lib.h.d.d(" key value is " + str);
        String json = new Gson().toJson(groupSettingItemData);
        com.baidu.adp.lib.h.d.d(" json value is " + json);
        p.a(str, json, 315532800000L);
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
        com.baidu.adp.lib.h.d.d("uid:" + str + " gid:" + str2 + "is in" + a2.isInGroup());
        return a2.isInGroup();
    }

    public static void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.m.a(new x(str, str2, j), aVar);
    }
}
