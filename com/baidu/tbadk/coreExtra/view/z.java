package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements a.e {
    final /* synthetic */ MultiImageView alK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(MultiImageView multiImageView) {
        this.alK = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        i iVar;
        iVar = this.alK.alE;
        if (iVar.getSelectedView() == aVar) {
            this.alK.setZoomButton(aVar);
        }
    }
}
