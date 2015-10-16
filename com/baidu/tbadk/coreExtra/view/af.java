package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ z amj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.amj = zVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.amj.amb = true;
        this.amj.mProgressBar.setVisibility(8);
        this.amj.b(aVar);
    }
}
