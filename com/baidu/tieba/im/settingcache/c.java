package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends a {
    private static c bpR = new c();

    private c() {
    }

    public static c UN() {
        return bpR;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aL */
    public GroupSettingItemData aJ(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bpO) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bpO.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (n.jl()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void Rl() {
        super.s(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aJ = aJ(str, str2);
        if (aJ != null) {
            aJ.setAlreadyApply(z);
            aJ.setLastApplyTimeStamp(System.currentTimeMillis());
            a(aJ, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aJ = aJ(str, str2);
        if (aJ != null) {
            aJ.setInGroup(z);
            a(aJ, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.l.a(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> UM() {
        return com.baidu.tbadk.core.b.a.rI().ck("tb.im_group_setting");
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
            t<String> UM = UM();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.bpO) {
                this.bpO.put(str, groupSettingItemData);
            }
            UM.f(str, jsonStrWithObject);
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
            synchronized (this.bpO) {
                this.bpO.put(str, groupSettingItemData);
            }
            com.baidu.tieba.im.l.a(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tieba.im.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.bpO) {
                this.bpO.remove(str3);
            }
            com.baidu.tieba.im.l.a(new f(this, str3), gVar);
        }
    }
}
