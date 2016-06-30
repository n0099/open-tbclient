package com.baidu.tieba.homepage.framework;

import android.view.View;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ RecommendFrsControlFragment cow;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(RecommendFrsControlFragment recommendFrsControlFragment) {
        this.cow = recommendFrsControlFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q qVar;
        q qVar2;
        qVar = this.cow.coj;
        if (qVar != null) {
            qVar2 = this.cow.coj;
            qVar2.a(1, true, 0, 0, 1, 0);
            this.cow.IM();
            this.cow.h(false, this.cow.getResources().getDimensionPixelSize(u.e.ds520));
        }
    }
}
