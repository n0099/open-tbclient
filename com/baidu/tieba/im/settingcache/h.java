package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
public class h extends a {
    private static h bHF = new h();

    private h() {
    }

    public static h Xi() {
        return bHF;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aN */
    public OfficialSettingItemData aK(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bHx) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bHx.get(str3);
            officialSettingItemData = (aVar == null || !(aVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) aVar;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.k.jc()) {
                a(officialSettingItemData2, null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void TE() {
        super.l(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData aK;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (aK = aK(str, str2)) != null) {
            aK.setToPortrait(userData.getPortrait());
            aK.setToName(userData.getUserName());
            a(aK);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> Xf() {
        return com.baidu.tbadk.core.b.a.sO().cr("tb.im_official_chat_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar) {
        if (aVar != null && (aVar instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) aVar;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            o<String> Xf = Xf();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(officialSettingItemData);
            synchronized (this.bHx) {
                this.bHx.put(str, officialSettingItemData);
            }
            Xf.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.d<Void> dVar) {
        if (aVar != null && (aVar instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) aVar;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            String str = String.valueOf(myUid) + "@" + toUid;
            synchronized (this.bHx) {
                this.bHx.put(str, officialSettingItemData);
            }
            m.b(new i(this, officialSettingItemData, str), dVar);
        }
    }
}
