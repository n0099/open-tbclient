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
    private static b dEn = new b();

    private b() {
    }

    public static b azd() {
        return dEn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bl */
    public GroupSettingItemData bj(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.dEk) {
            ChatSetting chatSetting = this.dEk.get(str3);
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

    public void ava() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bj = bj(str, str2);
        if (bj != null) {
            bj.setAlreadyApply(z);
            bj.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bj, gVar);
        }
    }

    public void c(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bj = bj(str, str2);
        if (bj != null) {
            bj.setInGroup(z);
            a(bj, gVar);
        }
    }

    public void a(final String str, final String str2, final long j, g<Boolean> gVar) {
        t.b(new s<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.s
            public Boolean doInBackground() {
                GroupSettingItemData bj = b.this.bj(str, str2);
                if (bj != null && bj.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bj.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, gVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> azc() {
        return com.baidu.tbadk.core.c.a.te().cJ("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> azc = azc();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.dEk) {
                this.dEk.put(str, groupSettingItemData);
            }
            azc.e(str, jsonStrWithObject);
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
            synchronized (this.dEk) {
                this.dEk.put(str, groupSettingItemData);
            }
            t.b(new s<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.s
                /* renamed from: LP */
                public Void doInBackground() {
                    b.this.azc().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, gVar);
        }
    }

    public void b(String str, String str2, g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.dEk) {
                this.dEk.remove(str3);
            }
            t.b(new s<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.s
                /* renamed from: LP */
                public Void doInBackground() {
                    b.this.azc().remove(str3);
                    return null;
                }
            }, gVar);
        }
    }
}
