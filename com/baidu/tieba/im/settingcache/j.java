package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class j extends a {
    private static j dfg = new j();

    private j() {
    }

    public static j atz() {
        return dfg;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bk */
    public PersonalSettingItemData bg(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.deV) {
            ChatSetting chatSetting = this.deV.get(str3);
            personalSettingItemData = (chatSetting == null || !(chatSetting instanceof PersonalSettingItemData)) ? null : (PersonalSettingItemData) chatSetting;
        }
        if (personalSettingItemData == null) {
            PersonalSettingItemData personalSettingItemData2 = new PersonalSettingItemData();
            personalSettingItemData2.setMyUid(str);
            personalSettingItemData2.setToUid(str2);
            personalSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.k.hz()) {
                a(personalSettingItemData2, null);
                return personalSettingItemData2;
            }
            a(personalSettingItemData2);
            return personalSettingItemData2;
        }
        return personalSettingItemData;
    }

    public void apt() {
        super.m(PersonalSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        PersonalSettingItemData bg;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bg = bg(str, str2)) != null) {
            bg.setToPortrait(userData.getPortrait());
            bg.setToName(userData.getUserName());
            a(bg);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> atv() {
        return com.baidu.tbadk.core.c.a.tM().cB("tb.im_personal_chat_setting");
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
            o<String> atv = atv();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.deV) {
                this.deV.put(str, personalSettingItemData);
            }
            atv.k(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, com.baidu.tbadk.util.f<Void> fVar) {
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
            String str = String.valueOf(myUid) + "@" + toUid;
            synchronized (this.deV) {
                this.deV.put(str, personalSettingItemData);
            }
            t.b(new k(this, personalSettingItemData, str), fVar);
        }
    }
}
