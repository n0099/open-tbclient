package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends v<Void> {
    final /* synthetic */ h dbw;
    private final /* synthetic */ OfficialSettingItemData dbx;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dbw = hVar;
        this.dbx = officialSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        this.dbw.arq().k(this.val$key, OrmObject.jsonStrWithObject(this.dbx));
        return null;
    }
}
