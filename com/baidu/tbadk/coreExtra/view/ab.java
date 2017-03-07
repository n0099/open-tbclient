package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u avM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.avM = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.avM.avC = true;
        this.avM.mProgressBar.setVisibility(8);
        this.avM.b(aVar);
    }
}
