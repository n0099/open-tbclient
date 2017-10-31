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
public class d extends a {
    private static d dLS = new d();

    private d() {
    }

    public static d aBv() {
        return dLS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bg */
    public OfficialSettingItemData bd(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dLK) {
            ChatSetting chatSetting = this.dLK.get(str3);
            officialSettingItemData = (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) chatSetting;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (l.hx()) {
                a(officialSettingItemData2, null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void axq() {
        super.m(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData bd;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bd = bd(str, str2)) != null) {
            bd.setToPortrait(userData.getPortrait());
            bd.setToName(userData.getUserName());
            a(bd);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> aBs() {
        return com.baidu.tbadk.core.c.a.td().cP("tb.im_official_chat_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting) {
        if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            com.baidu.adp.lib.cache.l<String> aBs = aBs();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.dLK) {
                this.dLK.put(str, officialSettingItemData);
            }
            aBs.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, h<Void> hVar) {
        if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            final OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            final String str = myUid + "@" + toUid;
            synchronized (this.dLK) {
                this.dLK.put(str, officialSettingItemData);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: LS */
                public Void doInBackground() {
                    d.this.aBs().e(str, OrmObject.jsonStrWithObject(officialSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
