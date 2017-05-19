package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements b.e {
    final /* synthetic */ MultiImageView aut;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MultiImageView multiImageView) {
        this.aut = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.b.e
    public void a(com.baidu.tbadk.widget.b bVar, boolean z, boolean z2) {
        h hVar;
        hVar = this.aut.aum;
        if (hVar.getSelectedView() == bVar) {
            this.aut.setZoomButton(bVar);
        }
    }
}
