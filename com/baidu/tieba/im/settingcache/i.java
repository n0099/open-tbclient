package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ h bHG;
    private final /* synthetic */ OfficialSettingItemData bHH;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bHG = hVar;
        this.bHH = officialSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gh */
    public Void doInBackground() {
        this.bHG.Xb().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bHH));
        return null;
    }
}
