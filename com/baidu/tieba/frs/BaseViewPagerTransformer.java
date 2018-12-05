package com.baidu.tieba.frs;

import android.support.v4.view.ViewPager;
import android.view.View;
/* loaded from: classes6.dex */
public abstract class BaseViewPagerTransformer implements ViewPager.PageTransformer {
    protected abstract void m(View view, float f);

    @Override // android.support.v4.view.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        n(view, f);
        m(view, f);
        o(view, f);
    }

    protected boolean aAb() {
        return true;
    }

    protected boolean aAc() {
        return false;
    }

    protected void n(View view, float f) {
        float f2 = 0.0f;
        float width = view.getWidth();
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(aAc() ? 0.0f : (-width) * f);
        if (aAb()) {
            if (f > -1.0f && f < 1.0f) {
                f2 = 1.0f;
            }
            view.setAlpha(f2);
            view.setEnabled(false);
            return;
        }
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    protected void o(View view, float f) {
    }
}
