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
public class d extends a {
    private static d dAF = new d();

    private d() {
    }

    public static d ays() {
        return dAF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bp */
    public OfficialSettingItemData bm(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dAx) {
            ChatSetting chatSetting = this.dAx.get(str3);
            officialSettingItemData = (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) chatSetting;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (k.hH()) {
                a(officialSettingItemData2, null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void aus() {
        super.m(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData bm;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bm = bm(str, str2)) != null) {
            bm.setToPortrait(userData.getPortrait());
            bm.setToName(userData.getUserName());
            a(bm);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> ayp() {
        return com.baidu.tbadk.core.c.a.to().cT("tb.im_official_chat_setting");
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
            l<String> ayp = ayp();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.dAx) {
                this.dAx.put(str, officialSettingItemData);
            }
            ayp.k(str, jsonStrWithObject);
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
            synchronized (this.dAx) {
                this.dAx.put(str, officialSettingItemData);
            }
            u.b(new t<Void>() { // from class: com.baidu.tieba.im.settingcache.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.t
                /* renamed from: Lp */
                public Void doInBackground() {
                    d.this.ayp().k(str, OrmObject.jsonStrWithObject(officialSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
