package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c dgC;
    private final /* synthetic */ GroupSettingItemData dgE;
    private final /* synthetic */ String uq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dgC = cVar;
        this.dgE = groupSettingItemData;
        this.uq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        this.dgC.atC().k(this.uq, OrmObject.jsonStrWithObject(this.dgE));
        return null;
    }
}
