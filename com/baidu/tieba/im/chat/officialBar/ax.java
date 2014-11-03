package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class ax extends com.baidu.tieba.im.pushNotify.b {
    private static ax aSq = new ax();

    private ax() {
    }

    public static ax KE() {
        return aSq;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.b
    /* renamed from: al */
    public OfficialSettingItemData am(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bhw) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bhw.get(str3);
            officialSettingItemData = (aVar == null || !(aVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) aVar;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.m.fu()) {
                a(officialSettingItemData2, null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void KF() {
        super.h(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData am;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (am = am(str, str2)) != null) {
            am.setToPortrait(userData.getPortrait());
            am.setToName(userData.getUserName());
            a(am);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.pushNotify.b
    public com.baidu.adp.lib.cache.t<String> KG() {
        return com.baidu.tbadk.core.a.a.kS().bd("tb.im_official_chat_setting");
    }

    @Override // com.baidu.tieba.im.pushNotify.b
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
            com.baidu.adp.lib.cache.t<String> KG = KG();
            String str = String.valueOf(myUid) + "@" + toUid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(officialSettingItemData);
            synchronized (this.bhw) {
                this.bhw.put(str, officialSettingItemData);
            }
            KG.b(str, jsonStrWithObject);
        }
    }

    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.a<Void> aVar2) {
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
            synchronized (this.bhw) {
                this.bhw.put(str, officialSettingItemData);
            }
            com.baidu.tieba.im.e.a(new ay(this, officialSettingItemData, str), aVar2);
        }
    }
}
