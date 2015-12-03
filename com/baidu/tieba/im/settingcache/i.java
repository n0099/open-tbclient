package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends m<Void> {
    final /* synthetic */ h bXh;
    private final /* synthetic */ OfficialSettingItemData bXi;
    private final /* synthetic */ String tA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bXh = hVar;
        this.bXi = officialSettingItemData;
        this.tA = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        this.bXh.aaC().f(this.tA, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bXi));
        return null;
    }
}
