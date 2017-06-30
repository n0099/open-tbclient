package com.baidu.tieba.homepage.personalize;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends Animation {
    private final /* synthetic */ int cna;
    final /* synthetic */ x this$0;
    private final /* synthetic */ View zg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(x xVar, int i, View view) {
        this.this$0 = xVar;
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
