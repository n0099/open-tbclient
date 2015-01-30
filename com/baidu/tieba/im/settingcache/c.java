package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends a {
    private static c boZ = new c();

    private c() {
    }

    public static c Tr() {
        return boZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aI */
    public GroupSettingItemData aG(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.boW) {
            com.baidu.tieba.im.pushNotify.a aVar = this.boW.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.l.ft()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void MP() {
        super.s(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aG = aG(str, str2);
        if (aG != null) {
            aG.setAlreadyApply(z);
            aG.setLastApplyTimeStamp(System.currentTimeMillis());
            a(aG, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aG = aG(str, str2);
        if (aG != null) {
            aG.setInGroup(z);
            a(aG, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.i.a(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> Tq() {
        return com.baidu.tbadk.core.a.a.nV().bT("tb.im_group_setting");
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
            t<String> Tq = Tq();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.boW) {
                this.boW.put(str, groupSettingItemData);
            }
            Tq.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tieba.im.g<Void> gVar) {
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
            synchronized (this.boW) {
                this.boW.put(str, groupSettingItemData);
            }
            com.baidu.tieba.im.i.a(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tieba.im.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.boW) {
                this.boW.remove(str3);
            }
            com.baidu.tieba.im.i.a(new f(this, str3), gVar);
        }
    }
}
