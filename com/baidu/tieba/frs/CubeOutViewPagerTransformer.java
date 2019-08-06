package com.baidu.tieba.frs;

import android.view.View;
/* loaded from: classes4.dex */
public class CubeOutViewPagerTransformer extends BaseViewPagerTransformer {
    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    protected void n(View view, float f) {
        float a = ((float) a(f, -1.0d, 1.0d, -90.0d, 90.0d)) * 0.5f;
        view.setCameraDistance(5500 * 1.0f);
        if (f > 0.0f) {
            view.setRotationY(a);
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() * 0.5f);
            view.setLayerType(2, null);
        } else if (f < 0.0f) {
            view.setRotationY(a);
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

    @Override // com.baidu.tieba.frs.BaseViewPagerTransformer
    public boolean blo() {
        return true;
    }

    public static double a(double d, double d2, double d3, double d4, double d5) {
        return (((d - d2) / (d3 - d2)) * (d5 - d4)) + d4;
    }
}
