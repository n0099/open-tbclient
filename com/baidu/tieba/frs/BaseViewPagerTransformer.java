package com.baidu.tieba.frs;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
/* loaded from: classes4.dex */
public abstract class BaseViewPagerTransformer implements ViewPager.PageTransformer {
    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void c(View view, float f2) {
    }

    public void d(View view, float f2) {
        float width = view.getWidth();
        float f3 = 0.0f;
        view.setRotationX(0.0f);
        view.setRotationY(0.0f);
        view.setRotation(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationY(0.0f);
        view.setTranslationX(b() ? 0.0f : (-width) * f2);
        if (a()) {
            if (f2 > -1.0f && f2 < 1.0f) {
                f3 = 1.0f;
            }
            view.setAlpha(f3);
            view.setEnabled(false);
            return;
        }
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    public abstract void e(View view, float f2);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(View view, float f2) {
        d(view, f2);
        e(view, f2);
        c(view, f2);
    }
}
