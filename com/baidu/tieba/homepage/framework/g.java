package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cvC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cvC = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cvC.cvp;
        if (qVar != null) {
            qVar2 = this.cvC.cvp;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cvC.Kd();
            this.cvC.f(false, this.cvC.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
