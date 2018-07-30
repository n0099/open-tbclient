package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.g;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b eBT = new b();

    private b() {
    }

    public static b aNt() {
        return eBT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bu */
    public GroupSettingItemData bs(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.eBR) {
            ChatSetting chatSetting = this.eBR.get(str3);
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

    public void aJy() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bs = bs(str, str2);
        if (bs != null) {
            bs.setAlreadyApply(z);
            bs.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bs, gVar);
        }
    }

    public void c(String str, String str2, boolean z, g<Void> gVar) {
        GroupSettingItemData bs = bs(str, str2);
        if (bs != null) {
            bs.setInGroup(z);
            a(bs, gVar);
        }
    }

    public void a(final String str, final String str2, final long j, g<Boolean> gVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                GroupSettingItemData bs = b.this.bs(str, str2);
                if (bs != null && bs.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bs.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, gVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> aNs() {
        return com.baidu.tbadk.core.c.a.xb().dy("tb.im_group_setting");
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
            l<String> aNs = aNs();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.eBR) {
                this.eBR.put(str, groupSettingItemData);
            }
            aNs.e(str, jsonStrWithObject);
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
            synchronized (this.eBR) {
                this.eBR.put(str, groupSettingItemData);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: Rs */
                public Void doInBackground() {
                    b.this.aNs().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, gVar);
        }
    }

    public void b(String str, String str2, g<Void> gVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.eBR) {
                this.eBR.remove(str3);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: Rs */
                public Void doInBackground() {
                    b.this.aNs().remove(str3);
                    return null;
                }
            }, gVar);
        }
    }
}
