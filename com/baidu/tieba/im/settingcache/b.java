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
    private static b gJI = new b();

    private b() {
    }

    public static b bDF() {
        return gJI;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dp */
    public GroupSettingItemData dn(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gJG) {
            ChatSetting chatSetting = this.gJG.get(str3);
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

    public void bzP() {
        super.r(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData dn = dn(str, str2);
        if (dn != null) {
            dn.setAlreadyApply(z);
            dn.setLastApplyTimeStamp(System.currentTimeMillis());
            a(dn, kVar);
        }
    }

    public void c(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData dn = dn(str, str2);
        if (dn != null) {
            dn.setInGroup(z);
            a(dn, kVar);
        }
    }

    public void a(final String str, final String str2, final long j, k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                GroupSettingItemData dn = b.this.dn(str, str2);
                if (dn != null && dn.isAlreadyApply()) {
                    if (System.currentTimeMillis() - dn.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, kVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bDE() {
        return com.baidu.tbadk.core.c.a.afD().mB("tb.im_group_setting");
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
            l<String> bDE = bDE();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gJG) {
                this.gJG.put(str, groupSettingItemData);
            }
            bDE.f(str, jsonStrWithObject);
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
            synchronized (this.gJG) {
                this.gJG.put(str, groupSettingItemData);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: aBY */
                public Void doInBackground() {
                    b.this.bDE().f(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, kVar);
        }
    }

    public void b(String str, String str2, k<Void> kVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gJG) {
                this.gJG.remove(str3);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: aBY */
                public Void doInBackground() {
                    b.this.bDE().remove(str3);
                    return null;
                }
            }, kVar);
        }
    }
}
