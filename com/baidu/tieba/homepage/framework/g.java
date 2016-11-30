package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cHJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cHJ = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cHJ.cHw;
        if (qVar != null) {
            qVar2 = this.cHJ.cHw;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cHJ.JP();
            this.cHJ.i(false, this.cHJ.getResources().getDimensionPixelSize(r.e.ds520));
        }
    }
}
