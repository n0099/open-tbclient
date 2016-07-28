package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.h.d {
    final /* synthetic */ r crM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.crM = rVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.crM.asQ = false;
        aVar = this.crM.crK;
        if (aVar != null) {
            aVar2 = this.crM.crK;
            aVar2.ahi();
        }
        viewGroup = this.crM.crJ;
        view = this.crM.axO;
        viewGroup.removeView(view);
    }
}
