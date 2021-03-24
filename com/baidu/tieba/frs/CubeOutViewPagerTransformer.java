package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes4.dex */
public class CubeOutViewPagerTransformer extends BaseViewPagerTransformer {
    public static double f(double d2, double d3, double d4, double d5, double d6) {
        return (((d2 - d3) / (d4 - d3)) * (d6 - d5)) + d5;
    }

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public boolean b() {
        return true;
    }

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public void e(View view, float f2) {
        float f3 = ((float) f(f2, -1.0d, 1.0d, -90.0d, 90.0d)) * 0.5f;
        view.setCameraDistance(5500 * 1.0f);
        if (f2 > 0.0f) {
            view.setRotationY(f3);
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setLayerType(2, null);
        } else if (f2 < 0.0f) {
            view.setRotationY(f3);
            view.setPivotX(view.getWidth() * 1.0f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setLayerType(2, null);
        } else {
            view.setRotationY(0.0f);
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setLayerType(0, null);
        }
    }
}
