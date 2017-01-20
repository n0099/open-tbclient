package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u aqr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(u uVar) {
        this.aqr = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.aqr.aqh = true;
        this.aqr.mProgressBar.setVisibility(8);
        this.aqr.b(aVar);
    }
}
