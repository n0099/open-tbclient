package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h dgH;
    private final /* synthetic */ OfficialSettingItemData dgI;
    private final /* synthetic */ String uq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dgH = hVar;
        this.dgI = officialSettingItemData;
        this.uq = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: LT */
    public Void doInBackground() {
        this.dgH.atC().k(this.uq, OrmObject.jsonStrWithObject(this.dgI));
        return null;
    }
}
