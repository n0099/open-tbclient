package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.j;
import com.baidu.tbadk.util.y;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b gSH = new b();

    private b() {
    }

    public static b bHs() {
        return gSH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: ds */
    public GroupSettingItemData dq(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gSF) {
            ChatSetting chatSetting = this.gSF.get(str3);
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

    public void bDA() {
        super.t(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, j<Void> jVar) {
        GroupSettingItemData dq = dq(str, str2);
        if (dq != null) {
            dq.setAlreadyApply(z);
            dq.setLastApplyTimeStamp(System.currentTimeMillis());
            a(dq, jVar);
        }
    }

    public void c(String str, String str2, boolean z, j<Void> jVar) {
        GroupSettingItemData dq = dq(str, str2);
        if (dq != null) {
            dq.setInGroup(z);
            a(dq, jVar);
        }
    }

    public void a(final String str, final String str2, final long j, j<Boolean> jVar) {
        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                GroupSettingItemData dq = b.this.dq(str, str2);
                if (dq != null && dq.isAlreadyApply()) {
                    if (System.currentTimeMillis() - dq.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, jVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bHr() {
        return com.baidu.tbadk.core.d.a.agL().mN("tb.im_group_setting");
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
            l<String> bHr = bHr();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gSF) {
                this.gSF.put(str, groupSettingItemData);
            }
            bHr.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, j<Void> jVar) {
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
            synchronized (this.gSF) {
                this.gSF.put(str, groupSettingItemData);
            }
            z.b(new y<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: aDX */
                public Void doInBackground() {
                    b.this.bHr().f(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, jVar);
        }
    }

    public void b(String str, String str2, j<Void> jVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gSF) {
                this.gSF.remove(str3);
            }
            z.b(new y<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: aDX */
                public Void doInBackground() {
                    b.this.bHr().remove(str3);
                    return null;
                }
            }, jVar);
        }
    }
}
