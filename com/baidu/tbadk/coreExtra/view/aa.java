package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ u ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(u uVar) {
        this.ani = uVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.ani.amY = true;
        this.ani.mProgressBar.setVisibility(8);
        this.ani.b(aVar);
    }
}
