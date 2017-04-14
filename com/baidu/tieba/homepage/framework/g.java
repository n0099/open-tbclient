package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cuc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cuc = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cuc.ctP;
        if (qVar != null) {
            qVar2 = this.cuc.ctP;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cuc.KD();
            this.cuc.f(false, this.cuc.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
