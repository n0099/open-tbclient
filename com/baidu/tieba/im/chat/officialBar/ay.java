package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ax aSr;
    private final /* synthetic */ OfficialSettingItemData aSs;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.aSr = axVar;
        this.aSs = officialSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        this.aSr.KG().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.aSs));
        return null;
    }
}
