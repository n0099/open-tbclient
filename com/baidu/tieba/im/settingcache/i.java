package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends t<Void> {
    final /* synthetic */ h cZt;
    private final /* synthetic */ OfficialSettingItemData cZu;
    private final /* synthetic */ String kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cZt = hVar;
        this.cZu = officialSettingItemData;
        this.kj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        this.cZt.ars().k(this.kj, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cZu));
        return null;
    }
}
