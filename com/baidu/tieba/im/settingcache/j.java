package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class j extends a {
    private static j bnK = new j();

    private j() {
    }

    public static j SY() {
        return bnK;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aH */
    public PersonalSettingItemData aD(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bnz) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bnz.get(str3);
            personalSettingItemData = (aVar == null || !(aVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) aVar;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.l.fu()) {
                a(personalSettingItemData2, null);
                return personalSettingItemData2;
            }
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void Mt() {
        super.s(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData aD;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (aD = aD(str, str2)) != null) {
            aD.setToPortrait(userData.getPortrait());
            aD.setToName(userData.getUserName());
            a(aD);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> SU() {
        return com.baidu.tbadk.core.a.a.nS().bV("tb.im_personal_chat_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
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
            t<String> SU = SU();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(personalSettingItemData);
            synchronized (this.bnz) {
                this.bnz.put(str, personalSettingItemData);
            }
            SU.f(str, jsonStrWithObject);
        }
    }

    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar) {
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
            synchronized (this.bnz) {
                this.bnz.put(str, personalSettingItemData);
            }
            com.baidu.tieba.im.i.a(new k(this, personalSettingItemData, str), gVar);
        }
    }
}
