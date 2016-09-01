package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.e {
    final /* synthetic */ MultiImageView apt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MultiImageView multiImageView) {
        this.apt = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        h hVar;
        hVar = this.apt.apl;
        if (hVar.getSelectedView() == aVar) {
            this.apt.setZoomButton(aVar);
        }
    }
}
