package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ av cdV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(av avVar) {
        this.cdV = avVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            this.cdV.setHeaderViewHeight(i2);
        }
    }
}
