package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.u;
import com.baidu.tbadk.util.v;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b eNg = new b();

    private b() {
    }

    public static b aLU() {
        return eNg;
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
        synchronized (this.eNe) {
            ChatSetting chatSetting = this.eNe.get(str3);
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

    public void aHY() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bj = bj(str, str2);
        if (bj != null) {
            bj.setAlreadyApply(z);
            bj.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bj, hVar);
        }
    }

    public void c(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bj = bj(str, str2);
        if (bj != null) {
            bj.setInGroup(z);
            a(bj, hVar);
        }
    }

    public void a(final String str, final String str2, final long j, h<Boolean> hVar) {
        v.b(new u<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.u
            public Boolean doInBackground() {
                GroupSettingItemData bj = b.this.bj(str, str2);
                if (bj != null && bj.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bj.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, hVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> aLT() {
        return com.baidu.tbadk.core.c.a.AQ().dh("tb.im_group_setting");
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
            l<String> aLT = aLT();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.eNe) {
                this.eNe.put(str, groupSettingItemData);
            }
            aLT.e(str, jsonStrWithObject);
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
            synchronized (this.eNe) {
                this.eNe.put(str, groupSettingItemData);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: UP */
                public Void doInBackground() {
                    b.this.aLT().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }

    public void b(String str, String str2, h<Void> hVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.eNe) {
                this.eNe.remove(str3);
            }
            v.b(new u<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.u
                /* renamed from: UP */
                public Void doInBackground() {
                    b.this.aLT().remove(str3);
                    return null;
                }
            }, hVar);
        }
    }
}
