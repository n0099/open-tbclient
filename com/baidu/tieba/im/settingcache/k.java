package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tbadk.util.l<Void> {
    final /* synthetic */ j bIe;
    private final /* synthetic */ PersonalSettingItemData bIf;
    private final /* synthetic */ String tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, PersonalSettingItemData personalSettingItemData, String str) {
        this.bIe = jVar;
        this.bIf = personalSettingItemData;
        this.tz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.l
    /* renamed from: Ge */
    public Void doInBackground() {
        this.bIe.Xw().f(this.tz, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bIf));
        return null;
    }
}
