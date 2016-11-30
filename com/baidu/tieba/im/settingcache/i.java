package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends s<Void> {
    final /* synthetic */ h dsi;
    private final /* synthetic */ OfficialSettingItemData dsj;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.dsi = hVar;
        this.dsj = officialSettingItemData;
        this.mD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        this.dsi.ayC().k(this.mD, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dsj));
        return null;
    }
}
