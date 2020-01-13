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
    private static b hHx = new b();

    private b() {
    }

    public static b bWw() {
        return hHx;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: dy */
    public GroupSettingItemData dw(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.hHv) {
            ChatSetting chatSetting = this.hHv.get(str3);
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

    public void bSH() {
        super.x(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData dw = dw(str, str2);
        if (dw != null) {
            dw.setAlreadyApply(z);
            dw.setLastApplyTimeStamp(System.currentTimeMillis());
            a(dw, lVar);
        }
    }

    public void c(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData dw = dw(str, str2);
        if (dw != null) {
            dw.setInGroup(z);
            a(dw, lVar);
        }
    }

    public void a(final String str, final String str2, final long j, l<Boolean> lVar) {
        ac.b(new ab<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ab
            public Boolean doInBackground() {
                GroupSettingItemData dw = b.this.dw(str, str2);
                if (dw != null && dw.isAlreadyApply()) {
                    if (System.currentTimeMillis() - dw.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, lVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> bWv() {
        return com.baidu.tbadk.core.c.a.aCo().sA("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> bWv = bWv();
            String str = uid + "@" + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.hHv) {
                this.hHv.put(str, groupSettingItemData);
            }
            bWv.setForever(str, jsonStrWithObject);
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
            synchronized (this.hHv) {
                this.hHv.put(str, groupSettingItemData);
            }
            ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: aWq */
                public Void doInBackground() {
                    b.this.bWv().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, lVar);
        }
    }

    public void b(String str, String str2, l<Void> lVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + "@" + str2;
            synchronized (this.hHv) {
                this.hHv.remove(str3);
            }
            ac.b(new ab<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ab
                /* renamed from: aWq */
                public Void doInBackground() {
                    b.this.bWv().remove(str3);
                    return null;
                }
            }, lVar);
        }
    }
}
