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
    private static b gQH = new b();

    private b() {
    }

    public static b bEd() {
        return gQH;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dd */
    public GroupSettingItemData db(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gQF) {
            ChatSetting chatSetting = this.gQF.get(str3);
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

    public void bAk() {
        super.q(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, j<Void> jVar) {
        GroupSettingItemData db = db(str, str2);
        if (db != null) {
            db.setAlreadyApply(z);
            db.setLastApplyTimeStamp(System.currentTimeMillis());
            a(db, jVar);
        }
    }

    public void c(String str, String str2, boolean z, j<Void> jVar) {
        GroupSettingItemData db = db(str, str2);
        if (db != null) {
            db.setInGroup(z);
            a(db, jVar);
        }
    }

    public void a(final String str, final String str2, final long j, j<Boolean> jVar) {
        z.b(new y<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.y
            public Boolean doInBackground() {
                GroupSettingItemData db = b.this.db(str, str2);
                if (db != null && db.isAlreadyApply()) {
                    if (System.currentTimeMillis() - db.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, jVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bEc() {
        return com.baidu.tbadk.core.d.a.akN().nl("tb.im_group_setting");
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
            l<String> bEc = bEc();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gQF) {
                this.gQF.put(str, groupSettingItemData);
            }
            bEc.setForever(str, jsonStrWithObject);
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
            synchronized (this.gQF) {
                this.gQF.put(str, groupSettingItemData);
            }
            z.b(new y<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: aEg */
                public Void doInBackground() {
                    b.this.bEc().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, jVar);
        }
    }

    public void b(String str, String str2, j<Void> jVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gQF) {
                this.gQF.remove(str3);
            }
            z.b(new y<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.y
                /* renamed from: aEg */
                public Void doInBackground() {
                    b.this.bEc().remove(str3);
                    return null;
                }
            }, jVar);
        }
    }
}
