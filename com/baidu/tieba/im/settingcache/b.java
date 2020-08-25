package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes2.dex */
public class b extends a {
    private static b jyW = new b();

    private b() {
    }

    public static b cIh() {
        return jyW;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: eU */
    public GroupSettingItemData eS(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + UgcConstant.AT_RULE_TAG + str2;
        synchronized (this.jyU) {
            ChatSetting chatSetting = this.jyU.get(str3);
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

    public void cDV() {
        super.y(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData eS = eS(str, str2);
        if (eS != null) {
            eS.setAlreadyApply(z);
            eS.setLastApplyTimeStamp(System.currentTimeMillis());
            a(eS, lVar);
        }
    }

    public void c(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData eS = eS(str, str2);
        if (eS != null) {
            eS.setInGroup(z);
            a(eS, lVar);
        }
    }

    public void a(final String str, final String str2, final long j, l<Boolean> lVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                GroupSettingItemData eS = b.this.eS(str, str2);
                if (eS != null && eS.isAlreadyApply()) {
                    if (System.currentTimeMillis() - eS.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, lVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> cIg() {
        return com.baidu.tbadk.core.c.a.bhb().zx("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> cIg = cIg();
            String str = uid + UgcConstant.AT_RULE_TAG + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.jyU) {
                this.jyU.put(str, groupSettingItemData);
            }
            cIg.setForever(str, jsonStrWithObject);
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
            final String str = uid + UgcConstant.AT_RULE_TAG + gid;
            synchronized (this.jyU) {
                this.jyU.put(str, groupSettingItemData);
            }
            ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bBB */
                public Void doInBackground() {
                    b.this.cIg().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, lVar);
        }
    }

    public void b(String str, String str2, l<Void> lVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + UgcConstant.AT_RULE_TAG + str2;
            synchronized (this.jyU) {
                this.jyU.remove(str3);
            }
            ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bBB */
                public Void doInBackground() {
                    b.this.cIg().remove(str3);
                    return null;
                }
            }, lVar);
        }
    }
}
