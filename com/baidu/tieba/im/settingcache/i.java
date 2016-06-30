package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h cWy;
    private final /* synthetic */ OfficialSettingItemData cWz;
    private final /* synthetic */ String jG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cWy = hVar;
        this.cWz = officialSettingItemData;
        this.jG = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Jo */
    public Void doInBackground() {
        this.cWy.aqG().e(this.jG, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cWz));
        return null;
    }
}
