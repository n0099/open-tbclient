package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends t<Void> {
    final /* synthetic */ c cZo;
    private final /* synthetic */ GroupSettingItemData cZq;
    private final /* synthetic */ String kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.cZo = cVar;
        this.cZq = groupSettingItemData;
        this.kj = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Jn */
    public Void doInBackground() {
        this.cZo.ars().k(this.kj, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.cZq));
        return null;
    }
}
