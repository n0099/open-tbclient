package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class b extends a {
    private static b jHE = new b();

    private b() {
    }

    public static b cLO() {
        return jHE;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: fi */
    public GroupSettingItemData fg(String str, String str2) {
        GroupSettingItemData groupSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + UgcConstant.AT_RULE_TAG + str2;
        synchronized (this.jHC) {
            ChatSetting chatSetting = this.jHC.get(str3);
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

    public void cHC() {
        super.y(GroupSettingItemData.class);
    }

    public void b(String str, String str2, boolean z, m<Void> mVar) {
        GroupSettingItemData fg = fg(str, str2);
        if (fg != null) {
            fg.setAlreadyApply(z);
            fg.setLastApplyTimeStamp(System.currentTimeMillis());
            a(fg, mVar);
        }
    }

    public void c(String str, String str2, boolean z, m<Void> mVar) {
        GroupSettingItemData fg = fg(str, str2);
        if (fg != null) {
            fg.setInGroup(z);
            a(fg, mVar);
        }
    }

    public void a(final String str, final String str2, final long j, m<Boolean> mVar) {
        ae.b(new ad<Boolean>() { // from class: com.baidu.tieba.im.settingcache.b.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tbadk.util.ad
            public Boolean doInBackground() {
                GroupSettingItemData fg = b.this.fg(str, str2);
                if (fg != null && fg.isAlreadyApply()) {
                    if (System.currentTimeMillis() - fg.getLastApplyTimeStamp() <= j) {
                        return false;
                    }
                }
                return true;
            }
        }, mVar);
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> cLN() {
        return com.baidu.tbadk.core.c.a.bhV().zT("tb.im_group_setting");
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
            l<String> cLN = cLN();
            String str = uid + UgcConstant.AT_RULE_TAG + gid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(groupSettingItemData);
            synchronized (this.jHC) {
                this.jHC.put(str, groupSettingItemData);
            }
            cLN.setForever(str, jsonStrWithObject);
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
            final String str = uid + UgcConstant.AT_RULE_TAG + gid;
            synchronized (this.jHC) {
                this.jHC.put(str, groupSettingItemData);
            }
            ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.settingcache.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bCO */
                public Void doInBackground() {
                    b.this.cLN().setForever(str, OrmObject.jsonStrWithObject(groupSettingItemData));
                    return null;
                }
            }, mVar);
        }
    }

    public void b(String str, String str2, m<Void> mVar) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            final String str3 = str + UgcConstant.AT_RULE_TAG + str2;
            synchronized (this.jHC) {
                this.jHC.remove(str3);
            }
            ae.b(new ad<Void>() { // from class: com.baidu.tieba.im.settingcache.b.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.ad
                /* renamed from: bCO */
                public Void doInBackground() {
                    b.this.cLN().remove(str3);
                    return null;
                }
            }, mVar);
        }
    }
}
