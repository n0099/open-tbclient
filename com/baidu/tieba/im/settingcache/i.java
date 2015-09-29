package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ h bHv;
    private final /* synthetic */ OfficialSettingItemData bHw;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bHv = hVar;
        this.bHw = officialSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Gl */
    public Void doInBackground() {
        this.bHv.Xf().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bHw));
        return null;
    }
}
