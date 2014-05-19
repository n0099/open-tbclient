package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aa extends com.baidu.tieba.im.pushNotify.n {
    private static aa b = new aa();

    private aa() {
    }

    public static aa a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.n
    /* renamed from: a */
    public GroupSettingItemData b(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.m mVar = this.a.get(str3);
            groupSettingItemData = mVar instanceof GroupSettingItemData ? (GroupSettingItemData) mVar : null;
        }
        if (groupSettingItemData == null) {
            groupSettingItemData = (GroupSettingItemData) new Gson().fromJson(c().a(str3), (Class<Object>) GroupSettingItemData.class);
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

    public void b() {
        super.a(GroupSettingItemData.class);
    }

    public void a(String str, String str2, boolean z) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setAlreadyApply(z);
            b2.setLastApplyTimeStamp(System.currentTimeMillis());
            a(b2);
        }
    }

    public void b(String str, String str2, boolean z) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setInGroup(z);
            a(b2);
        }
    }

    public void c(String str, String str2, boolean z) {
        new ab(this, str, str2, z).execute(new Void[0]);
    }

    public boolean c(String str, String str2) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 == null) {
            return false;
        }
        return b2.isInGroup();
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.i.a(new ac(this, str, str2, j), aVar);
    }

    @Override // com.baidu.tieba.im.pushNotify.n
    protected com.baidu.adp.lib.cache.s<String> c() {
        return com.baidu.tbadk.core.a.b.a().w();
    }

    @Override // com.baidu.tieba.im.pushNotify.n
    public void a(com.baidu.tieba.im.pushNotify.m mVar) {
        if (mVar == null || !(mVar instanceof GroupSettingItemData)) {
            BdLog.d("value is wrong");
            return;
        }
        GroupSettingItemData groupSettingItemData = (GroupSettingItemData) mVar;
        String uid = groupSettingItemData.getUid();
        String gid = groupSettingItemData.getGid();
        if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
            if (TbConfig.getDebugSwitch()) {
                throw new RuntimeException("key param is null");
            }
            return;
        }
        com.baidu.adp.lib.cache.s<String> c = c();
        String str = String.valueOf(uid) + "@" + gid;
        String json = new Gson().toJson(groupSettingItemData);
        synchronized (this.a) {
            this.a.put(str, groupSettingItemData);
        }
        c.a(str, json);
    }
}
