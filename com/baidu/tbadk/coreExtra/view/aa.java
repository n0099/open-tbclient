package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u are;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.are = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.are.aqU = true;
        this.are.mProgressBar.setVisibility(8);
        this.are.b(aVar);
    }
}
