package com.baidu.tieba.im.chat.personaltalk;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.s;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class a extends com.baidu.tieba.im.pushNotify.n {
    private static a b = new a();

    private a() {
    }

    public static a a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.n
    /* renamed from: a */
    public PersonalSettingItemData b(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.m mVar = this.a.get(str3);
            personalSettingItemData = (mVar == null || !(mVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) mVar;
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
            BdLog.d("data:" + personalSettingItemData2.getMyUid() + "+" + personalSettingItemData2.getToUid());
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

    @Override // com.baidu.tieba.im.pushNotify.n
    protected s<String> c() {
        return com.baidu.tbadk.core.a.b.a().y();
    }

    @Override // com.baidu.tieba.im.pushNotify.n
    public void a(com.baidu.tieba.im.pushNotify.m mVar) {
        if (mVar == null || !(mVar instanceof PersonalSettingItemData)) {
            BdLog.d("value is wrong");
            return;
        }
        PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) mVar;
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
