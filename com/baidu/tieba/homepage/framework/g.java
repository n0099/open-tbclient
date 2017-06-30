package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cHu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cHu = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cHu.cHh;
        if (qVar != null) {
            qVar2 = this.cHu.cHh;
            qVar2.d(1, 0, 1, 0, 1);
            this.cHu.Np();
            this.cHu.g(false, this.cHu.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
