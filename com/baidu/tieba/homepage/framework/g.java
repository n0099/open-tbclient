package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cnd = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cnd.cmQ;
        if (qVar != null) {
            qVar2 = this.cnd.cmQ;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cnd.Jk();
            this.cnd.f(false, this.cnd.getResources().getDimensionPixelSize(r.e.ds520));
        }
    }
}
