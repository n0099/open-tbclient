package com.baidu.tieba.im.settingcache;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h dep;
    private final /* synthetic */ OfficialSettingItemData deq;
    private final /* synthetic */ String mw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dep = hVar;
        this.deq = officialSettingItemData;
        this.mw = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Li */
    public Void doInBackground() {
        this.dep.auh().k(this.mw, OrmObject.jsonStrWithObject(this.deq));
        return null;
    }
}
