package com.baidu.tieba.editortool;

import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
final class ae implements Animation.AnimationListener {
    private final /* synthetic */ af a;
    private final /* synthetic */ ViewGroup b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(af afVar, ViewGroup viewGroup) {
        this.a = afVar;
        this.b = viewGroup;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        if (this.a != null) {
            this.a.a();
        }
        this.b.setVisibility(0);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        this.b.setVisibility(8);
        if (this.a != null) {
            af afVar = this.a;
        }
    }
}
