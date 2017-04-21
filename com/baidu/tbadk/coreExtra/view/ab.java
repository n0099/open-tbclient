package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u awe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.awe = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.awe.avU = true;
        this.awe.mProgressBar.setVisibility(8);
        this.awe.b(aVar);
    }
}
