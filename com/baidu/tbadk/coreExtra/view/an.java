package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.widget.f {
    final /* synthetic */ MultiImageView OV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.OV = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.f
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        p pVar;
        pVar = this.OV.OP;
        if (pVar.getSelectedView() == aVar) {
            this.OV.setZoomButton(aVar);
        }
    }
}
