package com.baidu.tieba.homepage.framework.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.g.d {
    final /* synthetic */ o cvc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cvc = oVar;
    }

    @Override // com.baidu.adp.lib.g.d
    public void b(Animation animation) {
        TextView textView;
        Animation animation2;
        Animation animation3;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        textView = this.cvc.cuV;
        if (textView != null) {
            animation2 = this.cvc.cuY;
            if (animation == animation2) {
                textView4 = this.cvc.cuV;
                textView4.setVisibility(0);
                textView5 = this.cvc.cuV;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cvc.cuZ;
            if (animation == animation3) {
                textView2 = this.cvc.cuV;
                textView2.setVisibility(8);
                textView3 = this.cvc.cuV;
                textView3.setClickable(false);
            }
        }
    }
}
