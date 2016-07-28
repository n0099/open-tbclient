package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cqJ = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cqJ.cqx;
        if (qVar != null) {
            qVar2 = this.cqJ.cqx;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cqJ.IL();
            this.cqJ.i(false, this.cqJ.getResources().getDimensionPixelSize(u.e.ds520));
        }
    }
}
