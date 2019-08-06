package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.aa;
import com.baidu.tbadk.util.k;
import com.baidu.tbadk.util.z;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b gQN = new b();

    private b() {
    }

    public static b bGE() {
        return gQN;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dq */
    public GroupSettingItemData mo22do(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.gQL) {
            ChatSetting chatSetting = this.gQL.get(str3);
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

    public void bCM() {
        super.t(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData mo22do = mo22do(str, str2);
        if (mo22do != null) {
            mo22do.setAlreadyApply(z);
            mo22do.setLastApplyTimeStamp(System.currentTimeMillis());
            a(mo22do, kVar);
        }
    }

    public void c(String str, String str2, boolean z, k<Void> kVar) {
        GroupSettingItemData mo22do = mo22do(str, str2);
        if (mo22do != null) {
            mo22do.setInGroup(z);
            a(mo22do, kVar);
        }
    }

    public void a(final String str, final String str2, final long j, k<Boolean> kVar) {
        aa.b(new z<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.z
            public Boolean doInBackground() {
                GroupSettingItemData mo22do = b.this.mo22do(str, str2);
                if (mo22do != null && mo22do.isAlreadyApply()) {
                    if (System.currentTimeMillis() - mo22do.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, kVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> bGD() {
        return com.baidu.tbadk.core.d.a.agH().mL("tb.im_group_setting");
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
            l<String> bGD = bGD();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.gQL) {
                this.gQL.put(str, groupSettingItemData);
            }
            bGD.f(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, k<Void> kVar) {
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
            synchronized (this.gQL) {
                this.gQL.put(str, groupSettingItemData);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: aDt */
                public Void doInBackground() {
                    b.this.bGD().f(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, kVar);
        }
    }

    public void b(String str, String str2, k<Void> kVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.gQL) {
                this.gQL.remove(str3);
            }
            aa.b(new z<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.z
                /* renamed from: aDt */
                public Void doInBackground() {
                    b.this.bGD().remove(str3);
                    return null;
                }
            }, kVar);
        }
    }
}
