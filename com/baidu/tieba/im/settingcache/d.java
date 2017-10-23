package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class d extends a {
    private static d dEe = new d();

    private d() {
    }

    public static d aza() {
        return dEe;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bl */
    public OfficialSettingItemData bi(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dDW) {
            ChatSetting chatSetting = this.dDW.get(str3);
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

    public void auV() {
        super.m(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData bi;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bi = bi(str, str2)) != null) {
            bi.setToPortrait(userData.getPortrait());
            bi.setToName(userData.getUserName());
            a(bi);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> ayX() {
        return com.baidu.tbadk.core.c.a.sX().cI("tb.im_official_chat_setting");
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
            com.baidu.adp.lib.cache.l<String> ayX = ayX();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.dDW) {
                this.dDW.put(str, officialSettingItemData);
            }
            ayX.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, g<Void> gVar) {
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
            synchronized (this.dDW) {
                this.dDW.put(str, officialSettingItemData);
            }
            t.b(new s<Void>() { // from class: com.baidu.tieba.im.settingcache.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.s
                /* renamed from: LJ */
                public Void doInBackground() {
                    d.this.ayX().e(str, OrmObject.jsonStrWithObject(officialSettingItemData));
                    return null;
                }
            }, gVar);
        }
    }
}
