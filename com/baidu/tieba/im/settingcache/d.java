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
    private static d eQV = new d();

    private d() {
    }

    public static d aSV() {
        return eQV;
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
        synchronized (this.eQO) {
            ChatSetting chatSetting = this.eQO.get(str3);
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

    public void aOZ() {
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
    protected l<String> aSS() {
        return com.baidu.tbadk.core.c.a.Aq().eg("tb.im_official_chat_setting");
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
            l<String> aSS = aSS();
            String str = myUid + "@" + toUid;
            String jsonStrWithObject = OrmObject.jsonStrWithObject(officialSettingItemData);
            synchronized (this.eQO) {
                this.eQO.put(str, officialSettingItemData);
            }
            aSS.e(str, jsonStrWithObject);
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
            synchronized (this.eQO) {
                this.eQO.put(str, officialSettingItemData);
            }
            x.b(new w<Void>() { // from class: com.baidu.tieba.im.settingcache.d.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.w
                /* renamed from: Vh */
                public Void doInBackground() {
                    d.this.aSS().e(str, OrmObject.jsonStrWithObject(officialSettingItemData));
                    return null;
                }
            }, hVar);
        }
    }
}
