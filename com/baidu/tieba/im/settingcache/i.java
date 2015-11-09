package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ h bIb;
    private final /* synthetic */ OfficialSettingItemData bIc;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bIb = hVar;
        this.bIc = officialSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        this.bIb.Xw().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bIc));
        return null;
    }
}
