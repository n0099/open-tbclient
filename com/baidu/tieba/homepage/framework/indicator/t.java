package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.h.d {
    final /* synthetic */ r cCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cCU = rVar;
    }

    @Override // com.baidu.adp.lib.h.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.cCU.avX = false;
        aVar = this.cCU.cCS;
        if (aVar != null) {
            aVar2 = this.cCU.cCS;
            aVar2.alT();
        }
        viewGroup = this.cCU.cCR;
        view = this.cCU.aAV;
        viewGroup.removeView(view);
    }
}
