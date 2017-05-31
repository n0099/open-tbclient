package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.v;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends v<Void> {
    final /* synthetic */ c dgO;
    private final /* synthetic */ GroupSettingItemData dgQ;
    private final /* synthetic */ String val$key;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dgO = cVar;
        this.dgQ = groupSettingItemData;
        this.val$key = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.v
    /* renamed from: KF */
    public Void doInBackground() {
        this.dgO.aso().k(this.val$key, OrmObject.jsonStrWithObject(this.dgQ));
        return null;
    }
}
