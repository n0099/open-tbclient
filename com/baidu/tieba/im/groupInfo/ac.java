package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ aa bbM;
    private final /* synthetic */ GroupSettingItemData bbP;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar, GroupSettingItemData groupSettingItemData, String str) {
        this.bbM = aaVar;
        this.bbP = groupSettingItemData;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        this.bbM.KG().b(this.fR, com.baidu.adp.lib.a.b.a.a.i.jsonStrWithObject(this.bbP));
        return null;
    }
}
