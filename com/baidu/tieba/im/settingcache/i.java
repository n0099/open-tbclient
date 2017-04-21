package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h dhv;
    private final /* synthetic */ OfficialSettingItemData dhw;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dhv = hVar;
        this.dhw = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Mw */
    public Void doInBackground() {
        this.dhv.auw().k(this.val$key, OrmObject.jsonStrWithObject(this.dhw));
        return null;
    }
}
