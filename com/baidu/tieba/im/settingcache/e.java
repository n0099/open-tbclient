package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.s;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends s<Void> {
    final /* synthetic */ c crd;
    private final /* synthetic */ GroupSettingItemData crf;
    private final /* synthetic */ String jI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.crd = cVar;
        this.crf = groupSettingItemData;
        this.jI = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.s
    /* renamed from: Iq */
    public Void doInBackground() {
        this.crd.ais().e(this.jI, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.crf));
        return null;
    }
}
