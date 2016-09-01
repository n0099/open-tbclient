package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cBR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cBR = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cBR.cBF;
        if (qVar != null) {
            qVar2 = this.cBR.cBF;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cBR.La();
            this.cBR.h(false, this.cBR.getResources().getDimensionPixelSize(t.e.ds520));
        }
    }
}
