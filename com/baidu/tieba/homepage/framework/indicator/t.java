package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.h.d {
    final /* synthetic */ r coh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.coh = rVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.coh.avR = false;
        aVar = this.coh.cof;
        if (aVar != null) {
            aVar2 = this.coh.cof;
            aVar2.aiC();
        }
        viewGroup = this.coh.coe;
        view = this.coh.aAK;
        viewGroup.removeView(view);
    }
}
