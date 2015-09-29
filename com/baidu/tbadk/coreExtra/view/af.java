package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.imageManager.b {
    final /* synthetic */ z ami;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(z zVar) {
        this.ami = zVar;
    }

    @Override // com.baidu.tbadk.imageManager.b
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        this.ami.ama = true;
        this.ami.mProgressBar.setVisibility(8);
        this.ami.b(aVar);
    }
}
