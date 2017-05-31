package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.o;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class c extends a {
    private static c dgN = new c();

    private c() {
    }

    public static c asp() {
        return dgN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bf */
    public GroupSettingItemData bd(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = String.valueOf(str) + "@" + str2;
        synchronized (this.dgK) {
            ChatSetting chatSetting = this.dgK.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (com.baidu.adp.lib.util.k.hA()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void aon() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        GroupSettingItemData bd = bd(str, str2);
        if (bd != null) {
            bd.setAlreadyApply(z);
            bd.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bd, gVar);
        }
    }

    public void c(String str, String str2, boolean z, com.baidu.tbadk.util.g<Void> gVar) {
        GroupSettingItemData bd = bd(str, str2);
        if (bd != null) {
            bd.setInGroup(z);
            a(bd, gVar);
        }
    }

    public void a(String str, String str2, long j, com.baidu.tbadk.util.g<Boolean> gVar) {
        w.b(new d(this, str, str2, j), gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.settingcache.a
    public o<String> aso() {
        return com.baidu.tbadk.core.c.a.sY().cy("tb.im_group_setting");
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
            o<String> aso = aso();
            String str = String.valueOf(uid) + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.dgK) {
                this.dgK.put(str, groupSettingItemData);
            }
            aso.k(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, com.baidu.tbadk.util.g<Void> gVar) {
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
            synchronized (this.dgK) {
                this.dgK.put(str, groupSettingItemData);
            }
            w.b(new e(this, groupSettingItemData, str), gVar);
        }
    }

    public void b(String str, String str2, com.baidu.tbadk.util.g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String str3 = String.valueOf(str) + "@" + str2;
            synchronized (this.dgK) {
                this.dgK.remove(str3);
            }
            w.b(new f(this, str3), gVar);
        }
    }
}
