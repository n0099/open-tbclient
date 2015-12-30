package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements a.e {
    final /* synthetic */ MultiImageView anU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MultiImageView multiImageView) {
        this.anU = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        i iVar;
        iVar = this.anU.anN;
        if (iVar.getSelectedView() == aVar) {
            this.anU.setZoomButton(aVar);
        }
    }
}
