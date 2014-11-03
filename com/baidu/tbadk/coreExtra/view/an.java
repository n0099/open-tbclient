package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tbadk.widget.f {
    final /* synthetic */ MultiImageView OZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.OZ = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.f
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        p pVar;
        pVar = this.OZ.OT;
        if (pVar.getSelectedView() == aVar) {
            this.OZ.setZoomButton(aVar);
        }
    }
}
