package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.lib.g.e {
    final /* synthetic */ FloatingPersonalChatView aYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FloatingPersonalChatView floatingPersonalChatView) {
        this.aYV = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i iVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        iVar = this.aYV.aYJ;
        if (iVar.d(animation)) {
            linearLayout = this.aYV.aYI;
            if (linearLayout != null) {
                linearLayout2 = this.aYV.aYI;
                runnable = this.aYV.akA;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.im.floatwindow.b.MX().cF(false);
            this.aYV.aYP = true;
        }
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        iVar = this.aYV.aYJ;
        if (!iVar.d(animation)) {
            return;
        }
        this.aYV.exit();
    }
}
