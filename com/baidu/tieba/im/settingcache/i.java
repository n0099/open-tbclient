package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends w<Void> {
    final /* synthetic */ h doP;
    private final /* synthetic */ OfficialSettingItemData doQ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.doP = hVar;
        this.doQ = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.w
    /* renamed from: Ld */
    public Void doInBackground() {
        this.doP.avZ().k(this.val$key, OrmObject.jsonStrWithObject(this.doQ));
        return null;
    }
}
