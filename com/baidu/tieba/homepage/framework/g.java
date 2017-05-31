package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment czI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.czI = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.czI.czv;
        if (qVar != null) {
            qVar2 = this.czI.czv;
            qVar2.d(1, 0, 1, 0, 1);
            this.czI.Mx();
            this.czI.g(false, this.czI.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
