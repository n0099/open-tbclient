package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ au bVN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(au auVar) {
        this.bVN = auVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            this.bVN.setHeaderViewHeight(i2);
        }
    }
}
