package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends v<Void> {
    final /* synthetic */ c dbr;
    private final /* synthetic */ GroupSettingItemData dbt;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dbr = cVar;
        this.dbt = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: LK */
    public Void doInBackground() {
        this.dbr.arq().k(this.val$key, OrmObject.jsonStrWithObject(this.dbt));
        return null;
    }
}
