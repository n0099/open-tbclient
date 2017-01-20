package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cud;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cud = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cud.ctQ;
        if (qVar != null) {
            qVar2 = this.cud.ctQ;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cud.Jy();
            this.cud.f(false, this.cud.getResources().getDimensionPixelSize(r.f.ds520));
        }
    }
}
