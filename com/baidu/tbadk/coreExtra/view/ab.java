package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.awc = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.awc.avS = true;
        this.awc.mProgressBar.setVisibility(8);
        this.awc.b(aVar);
    }
}
