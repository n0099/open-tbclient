package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.ab;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b hLk = new b();

    private b() {
    }

    public static b bYs() {
        return hLk;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dF */
    public GroupSettingItemData dD(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.hLi) {
            ChatSetting chatSetting = this.hLi.get(str3);
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

    public void bUD() {
        super.x(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData dD = dD(str, str2);
        if (dD != null) {
            dD.setAlreadyApply(z);
            dD.setLastApplyTimeStamp(System.currentTimeMillis());
            a(dD, lVar);
        }
    }

    public void c(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData dD = dD(str, str2);
        if (dD != null) {
            dD.setInGroup(z);
            a(dD, lVar);
        }
    }

    public void a(final String str, final String str2, final long j, l<Boolean> lVar) {
        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ab
            public Boolean doInBackground() {
                GroupSettingItemData dD = b.this.dD(str, str2);
                if (dD != null && dD.isAlreadyApply()) {
                    if (System.currentTimeMillis() - dD.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, lVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> bYr() {
        return com.baidu.tbadk.core.c.a.aEF().sP("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> bYr = bYr();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.hLi) {
                this.hLi.put(str, groupSettingItemData);
            }
            bYr.setForever(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, l<Void> lVar) {
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
            synchronized (this.hLi) {
                this.hLi.put(str, groupSettingItemData);
            }
            ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: aYM */
                public Void doInBackground() {
                    b.this.bYr().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, lVar);
        }
    }

    public void b(String str, String str2, l<Void> lVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.hLi) {
                this.hLi.remove(str3);
            }
            ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: aYM */
                public Void doInBackground() {
                    b.this.bYr().remove(str3);
                    return null;
                }
            }, lVar);
        }
    }
}
