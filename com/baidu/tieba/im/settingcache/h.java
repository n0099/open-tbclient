package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class h extends a {
    private static h bnb = new h();

    private h() {
    }

    public static h Tp() {
        return bnb;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aH */
    public OfficialSettingItemData aE(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bmT) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bmT.get(str3);
            officialSettingItemData = (aVar == null || !(aVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) aVar;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (n.iW()) {
                a(officialSettingItemData2, null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void PJ() {
        super.s(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData aE;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (aE = aE(str, str2)) != null) {
            aE.setToPortrait(userData.getPortrait());
            aE.setToName(userData.getUserName());
            a(aE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> Tm() {
        return com.baidu.tbadk.core.b.a.rc().bX("tb.im_official_chat_setting");
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
            t<String> Tm = Tm();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(officialSettingItemData);
            synchronized (this.bmT) {
                this.bmT.put(str, officialSettingItemData);
            }
            Tm.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar) {
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
            synchronized (this.bmT) {
                this.bmT.put(str, officialSettingItemData);
            }
            com.baidu.tieba.im.l.a(new i(this, officialSettingItemData, str), gVar);
        }
    }
}
