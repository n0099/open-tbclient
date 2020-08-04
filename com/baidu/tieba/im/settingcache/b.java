package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b jjX = new b();

    private b() {
    }

    public static b cxq() {
        return jjX;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: eD */
    public GroupSettingItemData eB(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + UgcConstant.AT_RULE_TAG + str2;
        synchronized (this.jjV) {
            ChatSetting chatSetting = this.jjV.get(str3);
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

    public void cte() {
        super.y(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData eB = eB(str, str2);
        if (eB != null) {
            eB.setAlreadyApply(z);
            eB.setLastApplyTimeStamp(System.currentTimeMillis());
            a(eB, lVar);
        }
    }

    public void c(String str, String str2, boolean z, l<Void> lVar) {
        GroupSettingItemData eB = eB(str, str2);
        if (eB != null) {
            eB.setInGroup(z);
            a(eB, lVar);
        }
    }

    public void a(final String str, final String str2, final long j, l<Boolean> lVar) {
        ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ac
            public Boolean doInBackground() {
                GroupSettingItemData eB = b.this.eB(str, str2);
                if (eB != null && eB.isAlreadyApply()) {
                    if (System.currentTimeMillis() - eB.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, lVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected com.baidu.adp.lib.cache.l<String> cxp() {
        return com.baidu.tbadk.core.c.a.aYG().xj("tb.im_group_setting");
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
            com.baidu.adp.lib.cache.l<String> cxp = cxp();
            String str = uid + UgcConstant.AT_RULE_TAG + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.jjV) {
                this.jjV.put(str, groupSettingItemData);
            }
            cxp.setForever(str, jsonStrWithObject);
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
            synchronized (this.jjV) {
                this.jjV.put(str, groupSettingItemData);
            }
            ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bsE */
                public Void doInBackground() {
                    b.this.cxp().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, lVar);
        }
    }

    public void b(String str, String str2, l<Void> lVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + UgcConstant.AT_RULE_TAG + str2;
            synchronized (this.jjV) {
                this.jjV.remove(str3);
            }
            ad.b(new ac<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ac
                /* renamed from: bsE */
                public Void doInBackground() {
                    b.this.cxp().remove(str3);
                    return null;
                }
            }, lVar);
        }
    }
}
