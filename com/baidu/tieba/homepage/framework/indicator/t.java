package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.baidu.tieba.homepage.framework.indicator.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.lib.g.d {
    final /* synthetic */ r cwI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar) {
        this.cwI = rVar;
    }

    @Override // com.baidu.adp.lib.g.d, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        r.a aVar;
        ViewGroup viewGroup;
        View view;
        r.a aVar2;
        this.cwI.aAr = false;
        aVar = this.cwI.cwG;
        if (aVar != null) {
            aVar2 = this.cwI.cwG;
            aVar2.aiW();
        }
        viewGroup = this.cwI.cwF;
        view = this.cwI.rootView;
        viewGroup.removeView(view);
    }
}
