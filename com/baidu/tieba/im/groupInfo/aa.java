package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.gson.Gson;
/* loaded from: classes.dex */
public final class aa extends com.baidu.tieba.im.pushNotify.m {
    private static aa b = new aa();

    private aa() {
    }

    public static aa a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.m
    /* renamed from: a */
    public final GroupSettingItemData b(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.l lVar = this.a.get(str3);
            groupSettingItemData = lVar instanceof GroupSettingItemData ? (GroupSettingItemData) lVar : null;
        }
        if (groupSettingItemData == null) {
            groupSettingItemData = (GroupSettingItemData) new Gson().fromJson(com.baidu.tbadk.core.c.b.a().u().a(str3), (Class<Object>) GroupSettingItemData.class);
            if (groupSettingItemData != null) {
                a(GroupSettingItemData.class);
            }
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public final void b() {
        super.a(GroupSettingItemData.class);
    }

    public final void a(String str, String str2, boolean z) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setAlreadyApply(z);
            b2.setLastApplyTimeStamp(System.currentTimeMillis());
            a(b2);
        }
    }

    public final void b(String str, String str2, boolean z) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setInGroup(z);
            a(b2);
        }
    }

    public final void c(String str, String str2, boolean z) {
        new ab(this, str, str2, z).execute(new Void[0]);
    }

    public final boolean c(String str, String str2) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 == null) {
            return false;
        }
        return b2.isInGroup();
    }

    public final void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.s.a(new ac(this, str, str2, 60000L), aVar);
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    protected final com.baidu.adp.lib.cache.s<String> c() {
        return com.baidu.tbadk.core.c.b.a().u();
    }

    @Override // com.baidu.tieba.im.pushNotify.m
    public final void a(com.baidu.tieba.im.pushNotify.l lVar) {
        if (lVar == null || !(lVar instanceof GroupSettingItemData)) {
            com.baidu.adp.lib.util.f.e("value is wrong");
            return;
        }
        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) lVar;
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
            if (com.baidu.tbadk.core.data.n.a()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> u = com.baidu.tbadk.core.c.b.a().u();
        String str = String.valueOf(uid) + "@" + gid;
        String json = new Gson().toJson(groupSettingItemData);
        synchronized (this.a) {
            this.a.put(str, groupSettingItemData);
        }
        u.a(str, json);
    }
}
