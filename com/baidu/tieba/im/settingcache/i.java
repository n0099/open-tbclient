package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends p<Void> {
    final /* synthetic */ h cql;
    private final /* synthetic */ OfficialSettingItemData cqm;
    private final /* synthetic */ String tU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cql = hVar;
        this.cqm = officialSettingItemData;
        this.tU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        this.cql.aij().e(this.tU, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cqm));
        return null;
    }
}
