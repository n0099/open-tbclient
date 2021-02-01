package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b kMa = new b();

    private b() {
    }

    public static b cXR() {
        return kMa;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: fz */
    public GroupSettingItemData fx(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.kLY) {
            ChatSetting chatSetting = this.kLY.get(str3);
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

    public void cVr() {
        super.r(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, m<Void> mVar) {
        GroupSettingItemData fx = fx(str, str2);
        if (fx != null) {
            fx.setAlreadyApply(z);
            fx.setLastApplyTimeStamp(System.currentTimeMillis());
            a(fx, mVar);
        }
    }

    public void c(String str, String str2, boolean z, m<Void> mVar) {
        GroupSettingItemData fx = fx(str, str2);
        if (fx != null) {
            fx.setInGroup(z);
            a(fx, mVar);
        }
    }

    public void a(final String str, final String str2, final long j, m<Boolean> mVar) {
        af.b(new ae<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ae
            public Boolean doInBackground() {
                GroupSettingItemData fx = b.this.fx(str, str2);
                if (fx != null && fx.isAlreadyApply()) {
                    if (System.currentTimeMillis() - fx.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, mVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> cXQ() {
        return com.baidu.tbadk.core.c.a.bqr().As("tb.im_group_setting");
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
            l<String> cXQ = cXQ();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.kLY) {
                this.kLY.put(str, groupSettingItemData);
            }
            cXQ.setForever(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, m<Void> mVar) {
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
            synchronized (this.kLY) {
                this.kLY.put(str, groupSettingItemData);
            }
            af.b(new ae<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bLP */
                public Void doInBackground() {
                    b.this.cXQ().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, mVar);
        }
    }

    public void b(String str, String str2, m<Void> mVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.kLY) {
                this.kLY.remove(str3);
            }
            af.b(new ae<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ae
                /* renamed from: bLP */
                public Void doInBackground() {
                    b.this.cXQ().remove(str3);
                    return null;
                }
            }, mVar);
        }
    }
}
