package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements b.e {
    final /* synthetic */ MultiImageView aud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MultiImageView multiImageView) {
        this.aud = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.b.e
    public void a(com.baidu.tbadk.widget.b bVar, boolean z, boolean z2) {
        h hVar;
        hVar = this.aud.atW;
        if (hVar.getSelectedView() == bVar) {
            this.aud.setZoomButton(bVar);
        }
    }
}
