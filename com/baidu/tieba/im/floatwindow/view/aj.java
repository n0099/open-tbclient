package com.baidu.tieba.im.floatwindow.view;

import android.view.animation.Animation;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.adp.lib.g.e {
    final /* synthetic */ FloatingPersonalChatView bas;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(FloatingPersonalChatView floatingPersonalChatView) {
        this.bas = floatingPersonalChatView;
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        i iVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Runnable runnable;
        iVar = this.bas.baf;
        if (iVar.d(animation)) {
            linearLayout = this.bas.bae;
            if (linearLayout != null) {
                linearLayout2 = this.bas.bae;
                runnable = this.bas.ali;
                linearLayout2.removeCallbacks(runnable);
            }
            com.baidu.tieba.im.floatwindow.b.Nt().cK(false);
            this.bas.bal = true;
        }
    }

    @Override // com.baidu.adp.lib.g.e, android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        i iVar;
        iVar = this.bas.baf;
        if (!iVar.d(animation)) {
            return;
        }
        this.bas.exit();
    }
}
