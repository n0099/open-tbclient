package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.lib.g.e {
    final /* synthetic */ FloatingPersonalChatView baq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FloatingPersonalChatView floatingPersonalChatView) {
        this.baq = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i iVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        iVar = this.baq.bae;
        if (iVar.d(animation)) {
            linearLayout = this.baq.bad;
            if (linearLayout != null) {
                linearLayout2 = this.baq.bad;
                runnable = this.baq.alf;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.im.floatwindow.b.No().cK(false);
            this.baq.bak = true;
        }
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        iVar = this.baq.bae;
        if (!iVar.d(animation)) {
            return;
        }
        this.baq.exit();
    }
}
