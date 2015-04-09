package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.widget.h {
    final /* synthetic */ MultiImageView afC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.afC = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.h
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        p pVar;
        pVar = this.afC.afw;
        if (pVar.getSelectedView() == aVar) {
            this.afC.setZoomButton(aVar);
        }
    }
}
