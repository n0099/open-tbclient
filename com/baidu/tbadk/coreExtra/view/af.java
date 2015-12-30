package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ z apF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.apF = zVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.apF.apv = true;
        this.apF.mProgressBar.setVisibility(8);
        this.apF.b(aVar);
    }
}
