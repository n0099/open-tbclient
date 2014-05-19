package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public class az extends com.baidu.tieba.im.pushNotify.n {
    private static az b = new az();

    private az() {
    }

    public static az a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.n
    /* renamed from: a */
    public OfficialSettingItemData b(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.m mVar = this.a.get(str3);
            officialSettingItemData = (mVar == null || !(mVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) mVar;
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

    @Override // com.baidu.tieba.im.pushNotify.n
    protected com.baidu.adp.lib.cache.s<String> c() {
        return com.baidu.tbadk.core.a.b.a().y();
    }

    @Override // com.baidu.tieba.im.pushNotify.n
    public void a(com.baidu.tieba.im.pushNotify.m mVar) {
        if (mVar == null || !(mVar instanceof OfficialSettingItemData)) {
            BdLog.d("value is wrong");
            return;
        }
        OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) mVar;
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
