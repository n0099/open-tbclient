package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class e extends a {
    private static e dHl = new e();

    private e() {
    }

    public static e aAi() {
        return dHl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bu */
    public PersonalSettingItemData bq(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dHa) {
            ChatSetting chatSetting = this.dHa.get(str3);
            personalSettingItemData = (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) chatSetting;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (k.hy()) {
                a(personalSettingItemData2, null);
                return personalSettingItemData2;
            }
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void awe() {
        super.m(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData bq;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bq = bq(str, str2)) != null) {
            bq.setToPortrait(userData.getPortrait());
            bq.setToName(userData.getUserName());
            a(bq);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> aAe() {
        return com.baidu.tbadk.core.c.a.tk().cJ("tb.im_personal_chat_setting");
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
            l<String> aAe = aAe();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.dHa) {
                this.dHa.put(str, personalSettingItemData);
            }
            aAe.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, h<Void> hVar) {
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
            synchronized (this.dHa) {
                this.dHa.put(str, personalSettingItemData);
            }
            u.b(new t<Void>() { // from class: com.baidu.tieba.im.settingcache.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.t
                /* renamed from: Ly */
                public Void doInBackground() {
                    e.this.aAe().e(str, OrmObject.jsonStrWithObject(personalSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
