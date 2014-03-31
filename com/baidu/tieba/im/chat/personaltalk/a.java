package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public final class a extends com.baidu.tieba.im.pushNotify.m {
    private static a b = new a();

    private a() {
    }

    public static a a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.m
    /* renamed from: a */
    public final PersonalSettingItemData b(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.l lVar = this.a.get(str3);
            personalSettingItemData = (lVar == null || !(lVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) lVar;
        }
        if (personalSettingItemData == null) {
            personalSettingItemData = (PersonalSettingItemData) new Gson().fromJson(com.baidu.tbadk.core.c.b.a().v().a(str3), (Class<Object>) PersonalSettingItemData.class);
            if (personalSettingItemData != null) {
                super.a(PersonalSettingItemData.class);
            }
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            com.baidu.adp.lib.util.f.e("data:" + personalSettingItemData2.getMyUid() + "+" + personalSettingItemData2.getToUid());
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public final void b() {
        super.a(PersonalSettingItemData.class);
    }

    public final void a(String str, String str2, UserData userData) {
        PersonalSettingItemData b2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (b2 = b(str, str2)) != null) {
            b2.setToPortrait(userData.getPortrait());
            b2.setToName(userData.getUserName());
            a(b2);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    protected final s<String> c() {
        return com.baidu.tbadk.core.c.b.a().v();
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public final void a(com.baidu.tieba.im.pushNotify.l lVar) {
        if (lVar == null || !(lVar instanceof PersonalSettingItemData)) {
            com.baidu.adp.lib.util.f.e("value is wrong");
            return;
        }
        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) lVar;
        String myUid = personalSettingItemData.getMyUid();
        String toUid = personalSettingItemData.getToUid();
        if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
            if (com.baidu.tbadk.core.data.n.a()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        s<String> v = com.baidu.tbadk.core.c.b.a().v();
        String str = String.valueOf(myUid) + "@" + toUid;
        String json = new Gson().toJson(personalSettingItemData);
        synchronized (this.a) {
            this.a.put(str, personalSettingItemData);
        }
        v.a(str, json);
    }
}
