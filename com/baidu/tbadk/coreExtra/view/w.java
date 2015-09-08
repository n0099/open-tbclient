package com.baidu.tbadk.coreExtra.view;

import com.baidu.tbadk.widget.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements a.e {
    final /* synthetic */ MultiImageView amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MultiImageView multiImageView) {
        this.amq = multiImageView;
    }

    @Override // com.baidu.tbadk.widget.a.e
    public void a(com.baidu.tbadk.widget.a aVar, boolean z, boolean z2) {
        i iVar;
        iVar = this.amq.amk;
        if (iVar.getSelectedView() == aVar) {
            this.amq.setZoomButton(aVar);
        }
    }
}
