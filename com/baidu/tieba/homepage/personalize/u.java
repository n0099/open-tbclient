package com.baidu.tieba.homepage.personalize;

import android.view.animation.Animation;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(m mVar) {
        this.this$0 = mVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        TextView textView;
        TextView textView2;
        textView = this.this$0.WE;
        if (textView != null) {
            textView2 = this.this$0.WE;
            textView2.clearAnimation();
            this.this$0.amN();
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }
}
