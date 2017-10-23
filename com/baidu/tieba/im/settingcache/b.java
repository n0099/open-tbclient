package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.s;
import com.baidu.tbadk.util.t;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b dDZ = new b();

    private b() {
    }

    public static b ayY() {
        return dDZ;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bk */
    public GroupSettingItemData bi(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dDW) {
            ChatSetting chatSetting = this.dDW.get(str3);
            groupSettingItemData = chatSetting instanceof GroupSettingItemData ? (GroupSettingItemData) chatSetting : null;
        }
        if (groupSettingItemData == null) {
            GroupSettingItemData groupSettingItemData2 = new GroupSettingItemData();
            groupSettingItemData2.setUid(str);
            groupSettingItemData2.setGid(str2);
            groupSettingItemData2.setAcceptNotify(true);
            groupSettingItemData2.setInGroup(true);
            if (l.hx()) {
                a(groupSettingItemData2, null);
                return groupSettingItemData2;
            }
            a(groupSettingItemData2);
            return groupSettingItemData2;
        }
        return groupSettingItemData;
    }

    public void auV() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bi = bi(str, str2);
        if (bi != null) {
            bi.setAlreadyApply(z);
            bi.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bi, gVar);
        }
    }

    public void c(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bi = bi(str, str2);
        if (bi != null) {
            bi.setInGroup(z);
            a(bi, gVar);
        }
    }

    public void a(final String str, final String str2, final long j, g<Boolean> gVar) {
        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                GroupSettingItemData bi = b.this.bi(str, str2);
                if (bi != null && bi.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bi.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, gVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> ayX() {
        return com.baidu.tbadk.core.c.a.sX().cI("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> ayX = ayX();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.dDW) {
                this.dDW.put(str, groupSettingItemData);
            }
            ayX.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, g<Void> gVar) {
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
            synchronized (this.dDW) {
                this.dDW.put(str, groupSettingItemData);
            }
            t.b(new s<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.s
                /* renamed from: LJ */
                public Void doInBackground() {
                    b.this.ayX().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, gVar);
        }
    }

    public void b(String str, String str2, g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.dDW) {
                this.dDW.remove(str3);
            }
            t.b(new s<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.s
                /* renamed from: LJ */
                public Void doInBackground() {
                    b.this.ayX().remove(str3);
                    return null;
                }
            }, gVar);
        }
    }
}
