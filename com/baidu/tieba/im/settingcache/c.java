package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.m;
/* loaded from: classes.dex */
public class c extends a {
    private static c bHA = new c();

    private c() {
    }

    public static c Xg() {
        return bHA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aM */
    public GroupSettingItemData aK(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bHx) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bHx.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.k.jc()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void TE() {
        super.l(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tbadk.util.d<Void> dVar) {
        GroupSettingItemData aK = aK(str, str2);
        if (aK != null) {
            aK.setAlreadyApply(z);
            aK.setLastApplyTimeStamp(System.currentTimeMillis());
            a(aK, dVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tbadk.util.d<Void> dVar) {
        GroupSettingItemData aK = aK(str, str2);
        if (aK != null) {
            aK.setInGroup(z);
            a(aK, dVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tbadk.util.d<Boolean> dVar) {
        m.b(new d(this, str, str2, j), dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> Xf() {
        return com.baidu.tbadk.core.b.a.sO().cr("tb.im_group_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
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
            o<String> Xf = Xf();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.bHx) {
                this.bHx.put(str, groupSettingItemData);
            }
            Xf.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.d<Void> dVar) {
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
            synchronized (this.bHx) {
                this.bHx.put(str, groupSettingItemData);
            }
            m.b(new e(this, groupSettingItemData, str), dVar);
        }
    }

    public void b(String str, String str2, com.baidu.tbadk.util.d<Void> dVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.bHx) {
                this.bHx.remove(str3);
            }
            m.b(new f(this, str3), dVar);
        }
    }
}
