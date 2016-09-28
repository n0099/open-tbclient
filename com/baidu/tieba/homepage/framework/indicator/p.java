package com.baidu.tieba.homepage.framework.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.h.d {
    final /* synthetic */ o cDt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cDt = oVar;
    }

    @Override // com.baidu.adp.lib.h.d
    public void b(Animation animation) {
        TextView textView;
        Animation animation2;
        Animation animation3;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        textView = this.cDt.cDm;
        if (textView != null) {
            animation2 = this.cDt.cDp;
            if (animation == animation2) {
                textView4 = this.cDt.cDm;
                textView4.setVisibility(0);
                textView5 = this.cDt.cDm;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cDt.cDq;
            if (animation == animation3) {
                textView2 = this.cDt.cDm;
                textView2.setVisibility(8);
                textView3 = this.cDt.cDm;
                textView3.setClickable(false);
            }
        }
    }
}
