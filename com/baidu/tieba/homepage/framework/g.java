package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment ctq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.ctq = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.ctq.ctd;
        if (qVar != null) {
            qVar2 = this.ctq.ctd;
            qVar2.d(1, 0, 1, 0, 1);
            this.ctq.JR();
            this.ctq.g(false, this.ctq.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
