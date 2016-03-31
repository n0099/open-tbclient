package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends p<Void> {
    final /* synthetic */ c cqg;
    private final /* synthetic */ GroupSettingItemData cqi;
    private final /* synthetic */ String tU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cqg = cVar;
        this.cqi = groupSettingItemData;
        this.tU = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.p
    /* renamed from: JX */
    public Void doInBackground() {
        this.cqg.aij().e(this.tU, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cqi));
        return null;
    }
}
