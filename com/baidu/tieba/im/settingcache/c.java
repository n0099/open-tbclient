package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.q;
/* loaded from: classes.dex */
public class c extends a {
    private static c cqf = new c();

    private c() {
    }

    public static c aik() {
        return cqf;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bd */
    public GroupSettingItemData bb(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.cqc) {
            com.baidu.tieba.im.pushNotify.a aVar = this.cqc.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.k.jv()) {
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
        GroupSettingItemData bb = bb(str, str2);
        if (bb != null) {
            bb.setAlreadyApply(z);
            bb.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bb, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        GroupSettingItemData bb = bb(str, str2);
        if (bb != null) {
            bb.setInGroup(z);
            a(bb, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tbadk.util.g<Boolean> gVar) {
        q.b(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> aij() {
        return com.baidu.tbadk.core.b.a.um().cz("tb.im_group_setting");
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
            o<String> aij = aij();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.cqc) {
                this.cqc.put(str, groupSettingItemData);
            }
            aij.e(str, jsonStrWithObject);
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
            synchronized (this.cqc) {
                this.cqc.put(str, groupSettingItemData);
            }
            q.b(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tbadk.util.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.cqc) {
                this.cqc.remove(str3);
            }
            q.b(new f(this, str3), gVar);
        }
    }
}
