package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b gsH = new b();

    private b() {
    }

    public static b bwa() {
        return gsH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: db */
    public GroupSettingItemData cZ(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gsF) {
            ChatSetting chatSetting = this.gsF.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void bsg() {
        super.s(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData cZ = cZ(str, str2);
        if (cZ != null) {
            cZ.setAlreadyApply(z);
            cZ.setLastApplyTimeStamp(System.currentTimeMillis());
            a(cZ, kVar);
        }
    }

    public void c(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData cZ = cZ(str, str2);
        if (cZ != null) {
            cZ.setInGroup(z);
            a(cZ, kVar);
        }
    }

    public void a(final String str, final String str2, final long j, k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                GroupSettingItemData cZ = b.this.cZ(str, str2);
                if (cZ != null && cZ.isAlreadyApply()) {
                    if (System.currentTimeMillis() - cZ.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, kVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bvZ() {
        return com.baidu.tbadk.core.c.a.aaW().lv("tb.im_group_setting");
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
            l<String> bvZ = bvZ();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gsF) {
                this.gsF.put(str, groupSettingItemData);
            }
            bvZ.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, k<Void> kVar) {
        if (chatSetting != null && (chatSetting instanceof GroupSettingItemData)) {
            final GroupSettingItemData groupSettingItemData = (GroupSettingItemData) chatSetting;
            String uid = groupSettingItemData.getUid();
            String gid = groupSettingItemData.getGid();
            if (TextUtils.isEmpty(uid) || TextUtils.isEmpty(gid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            final String str = uid + "@" + gid;
            synchronized (this.gsF) {
                this.gsF.put(str, groupSettingItemData);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: awV */
                public Void doInBackground() {
                    b.this.bvZ().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, kVar);
        }
    }

    public void b(String str, String str2, k<Void> kVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gsF) {
                this.gsF.remove(str3);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: awV */
                public Void doInBackground() {
                    b.this.bvZ().remove(str3);
                    return null;
                }
            }, kVar);
        }
    }
}
