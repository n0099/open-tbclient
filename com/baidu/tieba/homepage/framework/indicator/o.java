package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.adp.lib.h.d {
    final /* synthetic */ m cpr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.cpr = mVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        m.a aVar;
        ViewGroup viewGroup;
        View view;
        m.a aVar2;
        this.cpr.asb = false;
        aVar = this.cpr.cpp;
        if (aVar != null) {
            aVar2 = this.cpr.cpp;
            aVar2.agC();
        }
        viewGroup = this.cpr.cpo;
        view = this.cpr.axa;
        viewGroup.removeView(view);
    }
}
