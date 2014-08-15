package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.pushNotify.b {
    private static a b = new a();

    private a() {
    }

    public static a a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.b
    /* renamed from: a */
    public PersonalSettingItemData b(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.a aVar = this.a.get(str3);
            personalSettingItemData = (aVar == null || !(aVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) aVar;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.j.b()) {
                a(personalSettingItemData2, (com.baidu.tieba.im.a<Void>) null);
                return personalSettingItemData2;
            }
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.pushNotify.b
    public t<String> c() {
        return com.baidu.tbadk.core.a.a.a().b("tb.im_personal_chat_setting");
    }

    @Override // com.baidu.tieba.im.pushNotify.b
    public void a(com.baidu.tieba.im.pushNotify.a aVar) {
        if (aVar != null && (aVar instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) aVar;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            t<String> c = c();
            String str = String.valueOf(myUid) + "@" + toUid;
            String json = new Gson().toJson(personalSettingItemData);
            synchronized (this.a) {
                this.a.put(str, personalSettingItemData);
            }
            c.a(str, json);
        }
    }

    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.a<Void> aVar2) {
        if (aVar != null && (aVar instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) aVar;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            String str = String.valueOf(myUid) + "@" + toUid;
            synchronized (this.a) {
                this.a.put(str, personalSettingItemData);
            }
            com.baidu.tieba.im.e.a(new b(this, personalSettingItemData, str), aVar2);
        }
    }
}
