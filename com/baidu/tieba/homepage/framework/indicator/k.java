package com.baidu.tieba.homepage.framework.indicator;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.adp.lib.h.d {
    final /* synthetic */ j cpl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.cpl = jVar;
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
        textView = this.cpl.cpe;
        if (textView != null) {
            animation2 = this.cpl.cph;
            if (animation == animation2) {
                textView4 = this.cpl.cpe;
                textView4.setVisibility(0);
                textView5 = this.cpl.cpe;
                textView5.setClickable(true);
                return;
            }
            animation3 = this.cpl.cpi;
            if (animation == animation3) {
                textView2 = this.cpl.cpe;
                textView2.setVisibility(8);
                textView3 = this.cpl.cpe;
                textView3.setClickable(false);
            }
        }
    }
}
