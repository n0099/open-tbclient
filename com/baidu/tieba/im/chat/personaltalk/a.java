package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.pushNotify.o {
    private static a b = new a();

    private a() {
    }

    public static a a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.o
    /* renamed from: a */
    public PersonalSettingItemData b(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.n nVar = this.a.get(str3);
            personalSettingItemData = (nVar == null || !(nVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) nVar;
        }
        if (personalSettingItemData == null) {
            personalSettingItemData = (PersonalSettingItemData) new Gson().fromJson(c().a(str3), (Class<Object>) PersonalSettingItemData.class);
            if (personalSettingItemData != null) {
                b();
            }
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void b() {
        super.a(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData b2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (b2 = b(str, str2)) != null) {
            b2.setToPortrait(userData.getPortrait());
            b2.setToName(userData.getUserName());
            a(b2);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.o
    protected s<String> c() {
        return com.baidu.tbadk.core.a.b.a().y();
    }

    @Override // com.baidu.tieba.im.pushNotify.o
    public void a(com.baidu.tieba.im.pushNotify.n nVar) {
        if (nVar != null && (nVar instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) nVar;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            s<String> c = c();
            String str = String.valueOf(myUid) + "@" + toUid;
            String json = new Gson().toJson(personalSettingItemData);
            synchronized (this.a) {
                this.a.put(str, personalSettingItemData);
            }
            c.a(str, json);
        }
    }
}
