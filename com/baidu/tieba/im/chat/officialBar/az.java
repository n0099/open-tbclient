package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class az extends com.baidu.tieba.im.pushNotify.b {
    private static az b = new az();

    private az() {
    }

    public static az a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.b
    /* renamed from: a */
    public OfficialSettingItemData b(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.a aVar = this.a.get(str3);
            officialSettingItemData = (aVar == null || !(aVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) aVar;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            if (com.baidu.adp.lib.util.j.b()) {
                a(officialSettingItemData2, (com.baidu.tieba.im.a<Void>) null);
                return officialSettingItemData2;
            }
            a(officialSettingItemData2);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void b() {
        super.a(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData b2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (b2 = b(str, str2)) != null) {
            b2.setToPortrait(userData.getPortrait());
            b2.setToName(userData.getUserName());
            a(b2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.pushNotify.b
    public com.baidu.adp.lib.cache.t<String> c() {
        return com.baidu.tbadk.core.a.a.a().b("tb.im_official_chat_setting");
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
            com.baidu.adp.lib.cache.t<String> c = c();
            String str = String.valueOf(myUid) + "@" + toUid;
            String json = new Gson().toJson(officialSettingItemData);
            synchronized (this.a) {
                this.a.put(str, officialSettingItemData);
            }
            c.a(str, json);
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
            synchronized (this.a) {
                this.a.put(str, officialSettingItemData);
            }
            com.baidu.tieba.im.e.a(new ba(this, officialSettingItemData, str), aVar2);
        }
    }
}
