package com.baidu.tieba.im.chat.officialBar;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
/* loaded from: classes.dex */
public final class bb extends com.baidu.tieba.im.pushNotify.m {
    private static bb b = new bb();

    private bb() {
    }

    public static bb a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.m
    /* renamed from: a */
    public final OfficialSettingItemData b(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.l lVar = this.a.get(str3);
            officialSettingItemData = (lVar == null || !(lVar instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) lVar;
        }
        if (officialSettingItemData == null) {
            officialSettingItemData = (OfficialSettingItemData) new Gson().fromJson(com.baidu.tbadk.core.c.b.a().w().a(str3), (Class<Object>) OfficialSettingItemData.class);
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

    public final void b() {
        super.a(OfficialSettingItemData.class);
    }

    public final void a(String str, String str2, UserData userData) {
        OfficialSettingItemData b2;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (b2 = b(str, str2)) != null) {
            b2.setToPortrait(userData.getPortrait());
            b2.setToName(userData.getUserName());
            a(b2);
        }
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    protected final com.baidu.adp.lib.cache.s<String> c() {
        return com.baidu.tbadk.core.c.b.a().w();
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public final void a(com.baidu.tieba.im.pushNotify.l lVar) {
        if (lVar == null || !(lVar instanceof OfficialSettingItemData)) {
            com.baidu.adp.lib.util.f.e("value is wrong");
            return;
        }
        OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) lVar;
        String myUid = officialSettingItemData.getMyUid();
        String toUid = officialSettingItemData.getToUid();
        if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
            if (com.baidu.tbadk.core.data.n.a()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> w = com.baidu.tbadk.core.c.b.a().w();
        String str = String.valueOf(myUid) + "@" + toUid;
        String json = new Gson().toJson(officialSettingItemData);
        synchronized (this.a) {
            this.a.put(str, officialSettingItemData);
        }
        w.a(str, json);
    }
}
