package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cwt = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cwt.cwg;
        if (qVar != null) {
            qVar2 = this.cwt.cwg;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cwt.KD();
            this.cwt.g(false, this.cwt.getResources().getDimensionPixelSize(w.f.ds520));
        }
    }
}
