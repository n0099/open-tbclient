package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u amC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.amC = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.amC.ams = true;
        this.amC.mProgressBar.setVisibility(8);
        this.amC.b(aVar);
    }
}
