package com.baidu.tbadk.coreExtra.view;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tbadk.widget.f {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.f
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        o oVar;
        oVar = this.a.e;
        if (oVar.getSelectedView() == aVar) {
            this.a.setZoomButton(aVar);
        }
    }
}
