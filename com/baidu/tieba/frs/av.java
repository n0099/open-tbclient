package com.baidu.tieba.frs;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ at bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(at atVar) {
        this.bPW = atVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void a(View view, int i, int i2, int i3, int i4) {
        if (i2 != i4) {
            this.bPW.setHeaderViewHeight(i2);
        }
    }
}
