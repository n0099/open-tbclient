package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class e extends a {
    private static e kDn = new e();

    private e() {
    }

    public static e daa() {
        return kDn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: fB */
    public PersonalSettingItemData fx(String str, String str2) {
        PersonalSettingItemData personalSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + UgcConstant.AT_RULE_TAG + str2;
        synchronized (this.kDd) {
            ChatSetting chatSetting = this.kDd.get(str3);
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

    public void cVO() {
        super.y(PersonalSettingItemData.class);
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
    protected l<String> cZW() {
        return com.baidu.tbadk.core.c.a.brq().Bo("tb.im_personal_chat_setting");
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
            l<String> cZW = cZW();
            String str = myUid + UgcConstant.AT_RULE_TAG + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(personalSettingItemData);
            synchronized (this.kDd) {
                this.kDd.put(str, personalSettingItemData);
            }
            cZW.setForever(str, jsonStrWithObject);
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
            final String str = myUid + UgcConstant.AT_RULE_TAG + toUid;
            synchronized (this.kDd) {
                this.kDd.put(str, personalSettingItemData);
            }
            ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.settingcache.e.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bMU */
                public Void doInBackground() {
                    e.this.cZW().setForever(str, OrmObject.jsonStrWithObject(personalSettingItemData));
                    return null;
                }
            }, mVar);
        }
    }
}
