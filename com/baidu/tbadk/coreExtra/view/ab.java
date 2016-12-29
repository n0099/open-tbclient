package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u arl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.arl = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.arl.arb = true;
        this.arl.mProgressBar.setVisibility(8);
        this.arl.b(aVar);
    }
}
