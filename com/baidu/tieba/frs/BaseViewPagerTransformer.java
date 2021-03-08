package com.baidu.tieba.frs;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes2.dex */
public abstract class BaseViewPagerTransformer implements ViewPager.PageTransformer {
    protected abstract void p(View view, float f);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f) {
        q(view, f);
        p(view, f);
        r(view, f);
    }

    protected boolean cBL() {
        return true;
    }

    protected boolean cBM() {
        return false;
    }

    protected void q(View view, float f) {
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
        view.setTranslationX(cBM() ? 0.0f : (-width) * f);
        if (cBL()) {
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

    protected void r(View view, float f) {
    }
}
