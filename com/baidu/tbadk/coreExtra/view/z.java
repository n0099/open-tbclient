package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z implements com.baidu.tbadk.widget.f {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.f
    public final void a(com.baidu.tbadk.widget.a aVar) {
        n nVar;
        nVar = this.a.e;
        if (nVar.getSelectedView() == aVar) {
            this.a.setZoomButton(aVar);
        }
    }
}
