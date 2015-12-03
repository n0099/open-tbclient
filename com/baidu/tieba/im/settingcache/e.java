package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends m<Void> {
    final /* synthetic */ c bXc;
    private final /* synthetic */ GroupSettingItemData bXe;
    private final /* synthetic */ String tA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bXc = cVar;
        this.bXe = groupSettingItemData;
        this.tA = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Hl */
    public Void doInBackground() {
        this.bXc.aaC().f(this.tA, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bXe));
        return null;
    }
}
