package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.widget.h {
    final /* synthetic */ MultiImageView agD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MultiImageView multiImageView) {
        this.agD = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.h
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        p pVar;
        pVar = this.agD.agx;
        if (pVar.getSelectedView() == aVar) {
            this.agD.setZoomButton(aVar);
        }
    }
}
