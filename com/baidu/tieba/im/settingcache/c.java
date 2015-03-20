package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.t;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class c extends a {
    private static c bmW = new c();

    private c() {
    }

    public static c Tn() {
        return bmW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: aG */
    public GroupSettingItemData aE(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bmT) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bmT.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (n.iW()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void PJ() {
        super.s(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aE = aE(str, str2);
        if (aE != null) {
            aE.setAlreadyApply(z);
            aE.setLastApplyTimeStamp(System.currentTimeMillis());
            a(aE, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tieba.im.g<Void> gVar) {
        GroupSettingItemData aE = aE(str, str2);
        if (aE != null) {
            aE.setInGroup(z);
            a(aE, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.g<Boolean> gVar) {
        com.baidu.tieba.im.l.a(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public t<String> Tm() {
        return com.baidu.tbadk.core.b.a.rc().bX("tb.im_group_setting");
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
            t<String> Tm = Tm();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.bmT) {
                this.bmT.put(str, groupSettingItemData);
            }
            Tm.f(str, jsonStrWithObject);
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
            synchronized (this.bmT) {
                this.bmT.put(str, groupSettingItemData);
            }
            com.baidu.tieba.im.l.a(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tieba.im.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.bmT) {
                this.bmT.remove(str3);
            }
            com.baidu.tieba.im.l.a(new f(this, str3), gVar);
        }
    }
}
