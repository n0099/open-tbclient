package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.h.d {
    final /* synthetic */ r cIM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cIM = rVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.cIM.awu = false;
        aVar = this.cIM.cIK;
        if (aVar != null) {
            aVar2 = this.cIM.cIK;
            aVar2.aoc();
        }
        viewGroup = this.cIM.cIJ;
        view = this.cIM.aBq;
        viewGroup.removeView(view);
    }
}
