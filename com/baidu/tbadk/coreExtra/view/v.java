package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.e {
    final /* synthetic */ MultiImageView akU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MultiImageView multiImageView) {
        this.akU = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        i iVar;
        iVar = this.akU.akO;
        if (iVar.getSelectedView() == aVar) {
            this.akU.setZoomButton(aVar);
        }
    }
}
