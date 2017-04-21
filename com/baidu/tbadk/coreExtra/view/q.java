package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.e {
    final /* synthetic */ MultiImageView aup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MultiImageView multiImageView) {
        this.aup = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        h hVar;
        hVar = this.aup.aui;
        if (hVar.getSelectedView() == aVar) {
            this.aup.setZoomButton(aVar);
        }
    }
}
