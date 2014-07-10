package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class bd extends com.baidu.tieba.im.pushNotify.o {
    private static bd b = new bd();

    private bd() {
    }

    public static bd a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.o
    /* renamed from: a */
    public OfficialSettingItemData b(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.n nVar = this.a.get(str3);
            officialSettingItemData = (nVar == null || !(nVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) nVar;
        }
        if (officialSettingItemData == null) {
            officialSettingItemData = (OfficialSettingItemData) new Gson().fromJson(c().a(str3), (Class<Object>) OfficialSettingItemData.class);
            if (officialSettingItemData != null) {
                a(OfficialSettingItemData.class);
            }
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
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

    @Override // com.baidu.tieba.im.pushNotify.o
    protected com.baidu.adp.lib.cache.s<String> c() {
        return com.baidu.tbadk.core.a.b.a().z();
    }

    @Override // com.baidu.tieba.im.pushNotify.o
    public void a(com.baidu.tieba.im.pushNotify.n nVar) {
        if (nVar != null && (nVar instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) nVar;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            com.baidu.adp.lib.cache.s<String> c = c();
            String str = String.valueOf(myUid) + "@" + toUid;
            String json = new Gson().toJson(officialSettingItemData);
            synchronized (this.a) {
                this.a.put(str, officialSettingItemData);
            }
            c.a(str, json);
        }
    }
}
