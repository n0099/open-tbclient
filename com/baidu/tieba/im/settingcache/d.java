package com.baidu.tieba.im.settingcache;

import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.cache.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.h;
import com.baidu.tbadk.util.w;
import com.baidu.tbadk.util.x;
import com.baidu.tieba.im.pushNotify.ChatSetting;
/* loaded from: classes.dex */
public class d extends a {
    private static d eSn = new d();

    private d() {
    }

    public static d aSs() {
        return eSn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.settingcache.a
    /* renamed from: bP */
    public OfficialSettingItemData bM(String str, String str2) {
        OfficialSettingItemData officialSettingItemData;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        String str3 = str + "@" + str2;
        synchronized (this.eSg) {
            ChatSetting chatSetting = this.eSg.get(str3);
            officialSettingItemData = (chatSetting == null || !(chatSetting instanceof OfficialSettingItemData)) ? null : (OfficialSettingItemData) chatSetting;
        }
        if (officialSettingItemData == null) {
            OfficialSettingItemData officialSettingItemData2 = new OfficialSettingItemData();
            officialSettingItemData2.setMyUid(str);
            officialSettingItemData2.setToUid(str2);
            officialSettingItemData2.setAcceptNotify(true);
            return officialSettingItemData2;
        }
        return officialSettingItemData;
    }

    public void aOw() {
        super.p(OfficialSettingItemData.class);
    }

    public void a(String str, String str2, UserData userData) {
        OfficialSettingItemData bM;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && userData != null && (bM = bM(str, str2)) != null) {
            bM.setToPortrait(userData.getPortrait());
            bM.setToName(userData.getUserName());
            a(bM);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    protected l<String> aSp() {
        return com.baidu.tbadk.core.c.a.Ax().eg("tb.im_official_chat_setting");
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting) {
        if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            l<String> aSp = aSp();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.eSg) {
                this.eSg.put(str, officialSettingItemData);
            }
            aSp.e(str, jsonStrWithObject);
        }
    }

    @Override // com.baidu.tieba.im.settingcache.a
    public void a(ChatSetting chatSetting, h<Void> hVar) {
        if (chatSetting != null && (chatSetting instanceof OfficialSettingItemData)) {
            final OfficialSettingItemData officialSettingItemData = (OfficialSettingItemData) chatSetting;
            String myUid = officialSettingItemData.getMyUid();
            String toUid = officialSettingItemData.getToUid();
            if (TextUtils.isEmpty(myUid) || TextUtils.isEmpty(toUid)) {
                if (TbConfig.getDebugSwitch()) {
                    throw new RuntimeException("key param is null");
                }
                return;
            }
            final String str = myUid + "@" + toUid;
            synchronized (this.eSg) {
                this.eSg.put(str, officialSettingItemData);
            }
            x.b(new w<Void>() { // from class: com.baidu.tieba.im.settingcache.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: Vq */
                public Void doInBackground() {
                    d.this.aSp().e(str, OrmObject.jsonStrWithObject(officialSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
