package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c dsd;
    private final /* synthetic */ GroupSettingItemData dsf;
    private final /* synthetic */ String mD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dsd = cVar;
        this.dsf = groupSettingItemData;
        this.mD = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Nb */
    public Void doInBackground() {
        this.dsd.ayC().k(this.mD, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dsf));
        return null;
    }
}
