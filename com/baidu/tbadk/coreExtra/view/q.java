package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.e {
    final /* synthetic */ MultiImageView apc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MultiImageView multiImageView) {
        this.apc = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        h hVar;
        hVar = this.apc.aoV;
        if (hVar.getSelectedView() == aVar) {
            this.apc.setZoomButton(aVar);
        }
    }
}
