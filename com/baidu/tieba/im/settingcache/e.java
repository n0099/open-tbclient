package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class e extends a {
    private static e dLV = new e();

    private e() {
    }

    public static e aBw() {
        return dLV;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bh */
    public PersonalSettingItemData bd(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dLK) {
            ChatSetting chatSetting = this.dLK.get(str3);
            personalSettingItemData = (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) chatSetting;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (l.hx()) {
                a(personalSettingItemData2, null);
                return personalSettingItemData2;
            }
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void axq() {
        super.m(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData bd;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bd = bd(str, str2)) != null) {
            bd.setToPortrait(userData.getPortrait());
            bd.setToName(userData.getUserName());
            a(bd);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> aBs() {
        return com.baidu.tbadk.core.c.a.td().cP("tb.im_personal_chat_setting");
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
            com.baidu.adp.lib.cache.l<String> aBs = aBs();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.dLK) {
                this.dLK.put(str, personalSettingItemData);
            }
            aBs.e(str, jsonStrWithObject);
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
            synchronized (this.dLK) {
                this.dLK.put(str, personalSettingItemData);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: LS */
                public Void doInBackground() {
                    e.this.aBs().e(str, OrmObject.jsonStrWithObject(personalSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
