package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.im.pushNotify.b {
    private static z bbx = new z();

    private z() {
    }

    public static z Pb() {
        return bbx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.pushNotify.b
    /* renamed from: ar */
    public GroupSettingItemData am(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.bhi) {
            com.baidu.tieba.im.pushNotify.a aVar = this.bhi.get(str3);
            groupSettingItemData = aVar instanceof GroupSettingItemData ? (GroupSettingItemData) aVar : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.m.fu()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void KB() {
        super.h(GroupSettingItemData.class);
    }

    public void a(String str, String str2, boolean z, com.baidu.tieba.im.a<Void> aVar) {
        GroupSettingItemData am = am(str, str2);
        if (am != null) {
            am.setAlreadyApply(z);
            am.setLastApplyTimeStamp(System.currentTimeMillis());
            a(am, aVar);
        }
    }

    public void b(String str, String str2, boolean z, com.baidu.tieba.im.a<Void> aVar) {
        GroupSettingItemData am = am(str, str2);
        if (am != null) {
            am.setInGroup(z);
            a(am, aVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tieba.im.a<Boolean> aVar) {
        com.baidu.tieba.im.e.a(new aa(this, str, str2, j), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.pushNotify.b
    public com.baidu.adp.lib.cache.t<String> KC() {
        return com.baidu.tbadk.core.a.a.kS().bd("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.t<String> KC = KC();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(groupSettingItemData);
            synchronized (this.bhi) {
                this.bhi.put(str, groupSettingItemData);
            }
            KC.b(str, jsonStrWithObject);
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
            synchronized (this.bhi) {
                this.bhi.put(str, groupSettingItemData);
            }
            com.baidu.tieba.im.e.a(new ab(this, groupSettingItemData, str), aVar2);
        }
    }

    public void a(String str, String str2, com.baidu.tieba.im.a<Void> aVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.bhi) {
                this.bhi.remove(str3);
            }
            com.baidu.tieba.im.e.a(new ac(this, str3), aVar);
        }
    }
}
