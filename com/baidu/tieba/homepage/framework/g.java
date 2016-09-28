package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cCw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cCw = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cCw.cCj;
        if (qVar != null) {
            qVar2 = this.cCw.cCj;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cCw.JJ();
            this.cCw.i(false, this.cCw.getResources().getDimensionPixelSize(r.e.ds520));
        }
    }
}
