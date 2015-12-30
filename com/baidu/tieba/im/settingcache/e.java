package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends m<Void> {
    final /* synthetic */ c cbb;
    private final /* synthetic */ GroupSettingItemData cbd;
    private final /* synthetic */ String tC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cbb = cVar;
        this.cbd = groupSettingItemData;
        this.tC = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.m
    /* renamed from: Ha */
    public Void doInBackground() {
        this.cbb.abK().f(this.tC, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cbd));
        return null;
    }
}
