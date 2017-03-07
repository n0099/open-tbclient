package com.baidu.tieba.homepage.framework.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.lib.g.d {
    final /* synthetic */ o cwC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.cwC = oVar;
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
        textView = this.cwC.cwv;
        if (textView != null) {
            animation2 = this.cwC.cwy;
            if (animation == animation2) {
                textView4 = this.cwC.cwv;
                textView4.setVisibility(0);
                textView5 = this.cwC.cwv;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cwC.cwz;
            if (animation == animation3) {
                textView2 = this.cwC.cwv;
                textView2.setVisibility(8);
                textView3 = this.cwC.cwv;
                textView3.setClickable(false);
            }
        }
    }
}
