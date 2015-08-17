package com.baidu.tieba.im.settingcache;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i extends com.baidu.tieba.im.h<Void> {
    final /* synthetic */ h bDL;
    private final /* synthetic */ OfficialSettingItemData bDM;
    private final /* synthetic */ String tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.bDL = hVar;
        this.bDM = officialSettingItemData;
        this.tB = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.h
    /* renamed from: GD */
    public Void doInBackground() {
        this.bDL.Wu().f(this.tB, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bDM));
        return null;
    }
}
