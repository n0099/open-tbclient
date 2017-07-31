package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.t;
import com.baidu.tbadk.util.u;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b dyD = new b();

    private b() {
    }

    public static b axO() {
        return dyD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bm */
    public GroupSettingItemData bk(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dyA) {
            ChatSetting chatSetting = this.dyA.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (k.hH()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void atQ() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bk = bk(str, str2);
        if (bk != null) {
            bk.setAlreadyApply(z);
            bk.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bk, hVar);
        }
    }

    public void c(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bk = bk(str, str2);
        if (bk != null) {
            bk.setInGroup(z);
            a(bk, hVar);
        }
    }

    public void a(final String str, final String str2, final long j, h<Boolean> hVar) {
        u.b(new t<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.t
            public Boolean doInBackground() {
                GroupSettingItemData bk = b.this.bk(str, str2);
                if (bk != null && bk.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bk.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, hVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> axN() {
        return com.baidu.tbadk.core.c.a.tn().cQ("tb.im_group_setting");
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
            l<String> axN = axN();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.dyA) {
                this.dyA.put(str, groupSettingItemData);
            }
            axN.k(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, h<Void> hVar) {
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
            synchronized (this.dyA) {
                this.dyA.put(str, groupSettingItemData);
            }
            u.b(new t<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.t
                /* renamed from: Lp */
                public Void doInBackground() {
                    b.this.axN().k(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }

    public void b(String str, String str2, h<Void> hVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.dyA) {
                this.dyA.remove(str3);
            }
            u.b(new t<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.t
                /* renamed from: Lp */
                public Void doInBackground() {
                    b.this.axN().remove(str3);
                    return null;
                }
            }, hVar);
        }
    }
}
