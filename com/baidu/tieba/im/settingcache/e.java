package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class e extends a {
    private static e kMw = new e();

    private e() {
    }

    public static e cYb() {
        return kMw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: fB */
    public PersonalSettingItemData fx(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.kMm) {
            ChatSetting chatSetting = this.kMm.get(str3);
            personalSettingItemData = (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) chatSetting;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void cVy() {
        super.r(PersonalSettingItemData.class);
    }

    public void b(String str, String str2, UserData userData) {
        PersonalSettingItemData fx;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (fx = fx(str, str2)) != null) {
            fx.setToPortrait(userData.getPortrait());
            fx.setToName(userData.getUserName());
            a(fx);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> cXX() {
        return com.baidu.tbadk.core.c.a.bqr().As("tb.im_personal_chat_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting) {
        if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            l<String> cXX = cXX();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.kMm) {
                this.kMm.put(str, personalSettingItemData);
            }
            cXX.setForever(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, m<Void> mVar) {
        if (chatSetting != null && (chatSetting instanceof PersonalSettingItemData)) {
            final PersonalSettingItemData personalSettingItemData = (PersonalSettingItemData) chatSetting;
            String myUid = personalSettingItemData.getMyUid();
            String toUid = personalSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            final String str = myUid + "@" + toUid;
            synchronized (this.kMm) {
                this.kMm.put(str, personalSettingItemData);
            }
            af.b(new ae<Void>() { // from class: com.baidu.tieba.im.settingcache.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bLW */
                public Void doInBackground() {
                    e.this.cXX().setForever(str, OrmObject.jsonStrWithObject(personalSettingItemData));
                    return null;
                }
            }, mVar);
        }
    }
}
