package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b eul = new b();

    private b() {
    }

    public static b aLN() {
        return eul;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bs */
    public GroupSettingItemData bq(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.euj) {
            ChatSetting chatSetting = this.euj.get(str3);
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

    public void aHQ() {
        super.m(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bq = bq(str, str2);
        if (bq != null) {
            bq.setAlreadyApply(z);
            bq.setLastApplyTimeStamp(System.currentTimeMillis());
            a(bq, hVar);
        }
    }

    public void c(String str, String str2, boolean z, h<Void> hVar) {
        GroupSettingItemData bq = bq(str, str2);
        if (bq != null) {
            bq.setInGroup(z);
            a(bq, hVar);
        }
    }

    public void a(final String str, final String str2, final long j, h<Boolean> hVar) {
        w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.v
            public Boolean doInBackground() {
                GroupSettingItemData bq = b.this.bq(str, str2);
                if (bq != null && bq.isAlreadyApply()) {
                    if (System.currentTimeMillis() - bq.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, hVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> aLM() {
        return com.baidu.tbadk.core.c.a.wW().dy("tb.im_group_setting");
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
            l<String> aLM = aLM();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.euj) {
                this.euj.put(str, groupSettingItemData);
            }
            aLM.e(str, jsonStrWithObject);
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
            synchronized (this.euj) {
                this.euj.put(str, groupSettingItemData);
            }
            w.b(new v<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.v
                /* renamed from: QO */
                public Void doInBackground() {
                    b.this.aLM().e(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }

    public void b(String str, String str2, h<Void> hVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.euj) {
                this.euj.remove(str3);
            }
            w.b(new v<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.v
                /* renamed from: QO */
                public Void doInBackground() {
                    b.this.aLM().remove(str3);
                    return null;
                }
            }, hVar);
        }
    }
}
