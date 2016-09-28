package com.baidu.tieba.im.settingcache;

import com.baidu.tbadk.util.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends t<Void> {
    final /* synthetic */ c dmu;
    private final /* synthetic */ GroupSettingItemData dmw;
    private final /* synthetic */ String mB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, GroupSettingItemData groupSettingItemData, String str) {
        this.dmu = cVar;
        this.dmw = groupSettingItemData;
        this.mB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.t
    /* renamed from: Mt */
    public Void doInBackground() {
        this.dmu.awF().k(this.mB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.dmw));
        return null;
    }
}
