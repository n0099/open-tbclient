package com.baidu.tieba.im.chat.officialBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ax aSd;
    private final /* synthetic */ OfficialSettingItemData aSe;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, OfficialSettingItemData officialSettingItemData, String str) {
        this.aSd = axVar;
        this.aSe = officialSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kb */
    public Void doInBackground() {
        this.aSd.KC().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.aSe));
        return null;
    }
}
