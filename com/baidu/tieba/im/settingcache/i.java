package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends m<Void> {
    final /* synthetic */ h cbg;
    private final /* synthetic */ OfficialSettingItemData cbh;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.cbg = hVar;
        this.cbh = officialSettingItemData;
        this.tC = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        this.cbg.abK().f(this.tC, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cbh));
        return null;
    }
}
