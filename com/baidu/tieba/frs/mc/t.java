package com.baidu.tieba.frs.mc;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* loaded from: classes.dex */
class t extends Animation {
    final /* synthetic */ q cmZ;
    private final /* synthetic */ int cna;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, int i, View view) {
        this.cmZ = qVar;
        this.cna = i;
        this.zg = view;
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        this.zg.getLayoutParams().height = this.cna - ((int) (this.cna * f));
        this.zg.requestLayout();
    }

    @Override // android.view.animation.Animation
    public boolean willChangeBounds() {
        return true;
    }
}
