package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class y extends com.baidu.tieba.im.pushNotify.b {
    private static y b = new y();

    private y() {
    }

    public static y a() {
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.b
    /* renamed from: a */
    public GroupSettingItemData b(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.a) {
            com.baidu.tieba.im.pushNotify.a aVar = this.a.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.j.b()) {
                a(groupSettingItemData2, (com.baidu.tieba.im.a<Void>) null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void b() {
        super.a(GroupSettingItemData.class);
    }

    public void a(String str, String str2, boolean z, com.baidu.tieba.im.a<Void> aVar) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setAlreadyApply(z);
            b2.setLastApplyTimeStamp(System.currentTimeMillis());
            a(b2, aVar);
        }
    }

    public void b(String str, String str2, boolean z, com.baidu.tieba.im.a<Void> aVar) {
        GroupSettingItemData b2 = b(str, str2);
        if (b2 != null) {
            b2.setInGroup(z);
            a(b2, aVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new z(this, str, str2, j), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.pushNotify.b
    public com.baidu.adp.lib.cache.t<String> c() {
        return com.baidu.tbadk.core.a.a.a().b("tb.im_group_setting");
    }

    @Override // com.baidu.tieba.im.pushNotify.b
    public void a(com.baidu.tieba.im.pushNotify.a aVar) {
        if (aVar != null && (aVar instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) aVar;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            com.baidu.adp.lib.cache.t<String> c = c();
            String str = String.valueOf(uid) + "@" + gid;
            String json = new Gson().toJson(groupSettingItemData);
            synchronized (this.a) {
                this.a.put(str, groupSettingItemData);
            }
            c.a(str, json);
        }
    }

    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.a<Void> aVar2) {
        if (aVar != null && (aVar instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) aVar;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            String str = String.valueOf(uid) + "@" + gid;
            synchronized (this.a) {
                this.a.put(str, groupSettingItemData);
            }
            com.baidu.tieba.im.e.a(new aa(this, groupSettingItemData, str), aVar2);
        }
    }

    public void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.a) {
                this.a.remove(str3);
            }
            com.baidu.tieba.im.e.a(new ab(this, str3), aVar);
        }
    }
}
