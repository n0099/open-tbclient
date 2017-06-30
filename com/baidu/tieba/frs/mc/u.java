package com.baidu.tieba.frs.mc;

import android.view.View;
import android.view.animation.Animation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements Animation.AnimationListener {
    final /* synthetic */ q cmZ;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar, View view) {
        this.cmZ = qVar;
        this.zg = view;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        this.zg.setVisibility(8);
        abVar = this.cmZ.cdt;
        if (abVar.adU() != null) {
            abVar2 = this.cmZ.cdt;
            if (abVar2.adU().aeI() != null) {
                abVar3 = this.cmZ.cdt;
                abVar3.adU().aeI().notifyDataSetChanged();
            }
        }
    }
}
