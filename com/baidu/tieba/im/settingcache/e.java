package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends m<Void> {
    final /* synthetic */ c cfB;
    private final /* synthetic */ GroupSettingItemData cfD;
    private final /* synthetic */ String tL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cfB = cVar;
        this.cfD = groupSettingItemData;
        this.tL = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: IB */
    public Void doInBackground() {
        this.cfB.aeQ().f(this.tL, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cfD));
        return null;
    }
}
