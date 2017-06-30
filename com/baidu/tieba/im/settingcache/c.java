package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class c extends a {
    private static c doJ = new c();

    private c() {
    }

    public static c awa() {
        return doJ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bm */
    public GroupSettingItemData bk(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.doG) {
            ChatSetting chatSetting = this.doG.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.k.hz()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void arY() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tbadk.util.h<Void> hVar) {
        GroupSettingItemData bk = bk(str, str2);
        if (bk != null) {
            bk.setAlreadyApply(z);
            bk.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bk, hVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tbadk.util.h<Void> hVar) {
        GroupSettingItemData bk = bk(str, str2);
        if (bk != null) {
            bk.setInGroup(z);
            a(bk, hVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tbadk.util.h<Boolean> hVar) {
        x.b(new d(this, str, str2, j), hVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> avZ() {
        return com.baidu.tbadk.core.c.a.sW().cF("tb.im_group_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting) {
        if (chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            o<String> avZ = avZ();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.doG) {
                this.doG.put(str, groupSettingItemData);
            }
            avZ.k(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, com.baidu.tbadk.util.h<Void> hVar) {
        if (chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            String str = String.valueOf(uid) + "@" + gid;
            synchronized (this.doG) {
                this.doG.put(str, groupSettingItemData);
            }
            x.b(new e(this, groupSettingItemData, str), hVar);
        }
    }

    public void b(String str, String str2, com.baidu.tbadk.util.h<Void> hVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.doG) {
                this.doG.remove(str3);
            }
            x.b(new f(this, str3), hVar);
        }
    }
}
