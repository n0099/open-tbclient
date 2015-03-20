package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class j extends a {
    private static j bne = new j();

    private j() {
    }

    public static j Tq() {
        return bne;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aI */
    public PersonalSettingItemData aE(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bmT) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bmT.get(str3);
            personalSettingItemData = (aVar == null || !(aVar instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) aVar;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (n.iW()) {
                a(personalSettingItemData2, null);
                return personalSettingItemData2;
            }
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void PJ() {
        super.s(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData aE;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (aE = aE(str, str2)) != null) {
            aE.setToPortrait(userData.getPortrait());
            aE.setToName(userData.getUserName());
            a(aE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> Tm() {
        return com.baidu.tbadk.core.b.a.rc().bX("tb.im_personal_chat_setting");
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
            t<String> Tm = Tm();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(personalSettingItemData);
            synchronized (this.bmT) {
                this.bmT.put(str, personalSettingItemData);
            }
            Tm.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
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
            synchronized (this.bmT) {
                this.bmT.put(str, personalSettingItemData);
            }
            com.baidu.tieba.im.l.a(new k(this, personalSettingItemData, str), gVar);
        }
    }
}
