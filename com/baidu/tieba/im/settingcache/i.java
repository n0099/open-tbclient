package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends m<Void> {
    final /* synthetic */ h cfG;
    private final /* synthetic */ OfficialSettingItemData cfH;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cfG = hVar;
        this.cfH = officialSettingItemData;
        this.tL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        this.cfG.aeQ().f(this.tL, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cfH));
        return null;
    }
}
