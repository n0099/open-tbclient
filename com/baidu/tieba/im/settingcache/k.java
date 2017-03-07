package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends s<Void> {
    final /* synthetic */ j dgK;
    private final /* synthetic */ PersonalSettingItemData dgL;
    private final /* synthetic */ String uq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.dgK = jVar;
        this.dgL = personalSettingItemData;
        this.uq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        this.dgK.atC().k(this.uq, OrmObject.jsonStrWithObject(this.dgL));
        return null;
    }
}
