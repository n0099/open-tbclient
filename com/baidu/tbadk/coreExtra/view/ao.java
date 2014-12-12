package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements com.baidu.tbadk.widget.h {
    final /* synthetic */ MultiImageView UK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(MultiImageView multiImageView) {
        this.UK = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.h
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        p pVar;
        pVar = this.UK.UE;
        if (pVar.getSelectedView() == aVar) {
            this.UK.setZoomButton(aVar);
        }
    }
}
