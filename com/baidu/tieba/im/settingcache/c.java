package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.t;
/* loaded from: classes.dex */
public class c extends a {
    private static c crc = new c();

    private c() {
    }

    public static c air() {
        return crc;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bh */
    public GroupSettingItemData bf(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.cqZ) {
            com.baidu.tieba.im.pushNotify.a aVar = this.cqZ.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.k.fG()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void aeo() {
        super.o(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        GroupSettingItemData bf = bf(str, str2);
        if (bf != null) {
            bf.setAlreadyApply(z);
            bf.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bf, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        GroupSettingItemData bf = bf(str, str2);
        if (bf != null) {
            bf.setInGroup(z);
            a(bf, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tbadk.util.g<Boolean> gVar) {
        t.b(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> aiq() {
        return com.baidu.tbadk.core.b.a.rR().cx("tb.im_group_setting");
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
            o<String> aiq = aiq();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.cqZ) {
                this.cqZ.put(str, groupSettingItemData);
            }
            aiq.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(com.baidu.tieba.im.pushNotify.a aVar, com.baidu.tbadk.util.g<Void> gVar) {
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
            synchronized (this.cqZ) {
                this.cqZ.put(str, groupSettingItemData);
            }
            t.b(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tbadk.util.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.cqZ) {
                this.cqZ.remove(str3);
            }
            t.b(new f(this, str3), gVar);
        }
    }
}
