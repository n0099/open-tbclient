package com.baidu.tieba.im.groupInfo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ aa bbM;
    private final /* synthetic */ String fR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar, String str) {
        this.bbM = aaVar;
        this.fR = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: Kf */
    public Void doInBackground() {
        this.bbM.KG().remove(this.fR);
        return null;
    }
}
