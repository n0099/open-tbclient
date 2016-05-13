package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h cri;
    private final /* synthetic */ OfficialSettingItemData crj;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cri = hVar;
        this.crj = officialSettingItemData;
        this.jI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        this.cri.ais().e(this.jI, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.crj));
        return null;
    }
}
