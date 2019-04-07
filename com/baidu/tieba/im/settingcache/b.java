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
    private static b gsu = new b();

    private b() {
    }

    public static b bvX() {
        return gsu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dc */
    public GroupSettingItemData da(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gss) {
            ChatSetting chatSetting = this.gss.get(str3);
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

    public void bsd() {
        super.s(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData da = da(str, str2);
        if (da != null) {
            da.setAlreadyApply(z);
            da.setLastApplyTimeStamp(System.currentTimeMillis());
            a(da, kVar);
        }
    }

    public void c(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData da = da(str, str2);
        if (da != null) {
            da.setInGroup(z);
            a(da, kVar);
        }
    }

    public void a(final String str, final String str2, final long j, k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                GroupSettingItemData da = b.this.da(str, str2);
                if (da != null && da.isAlreadyApply()) {
                    if (System.currentTimeMillis() - da.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, kVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bvW() {
        return com.baidu.tbadk.core.c.a.aaT().lw("tb.im_group_setting");
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
            l<String> bvW = bvW();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gss) {
                this.gss.put(str, groupSettingItemData);
            }
            bvW.e(str, jsonStrWithObject);
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
            synchronized (this.gss) {
                this.gss.put(str, groupSettingItemData);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: awS */
                public Void doInBackground() {
                    b.this.bvW().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, kVar);
        }
    }

    public void b(String str, String str2, k<Void> kVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gss) {
                this.gss.remove(str3);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: awS */
                public Void doInBackground() {
                    b.this.bvW().remove(str3);
                    return null;
                }
            }, kVar);
        }
    }
}
