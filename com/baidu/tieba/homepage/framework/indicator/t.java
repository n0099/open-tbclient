package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.g.d {
    final /* synthetic */ r cvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cvj = rVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.cvj.auW = false;
        aVar = this.cvj.cvh;
        if (aVar != null) {
            aVar2 = this.cvj.cvh;
            aVar2.ajK();
        }
        viewGroup = this.cvj.cvg;
        view = this.cvj.rootView;
        viewGroup.removeView(view);
    }
}
