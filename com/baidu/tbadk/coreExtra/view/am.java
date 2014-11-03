package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView OZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MultiImageView multiImageView) {
        this.OZ = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.OZ.OU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OZ.OU;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.OZ.OU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OZ.OU;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        p pVar;
        p pVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        p pVar3;
        boolean z2;
        p pVar4;
        com.baidu.tbadk.widget.a imageView;
        p pVar5;
        pVar = this.OZ.OT;
        View findViewWithTag = pVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof au) && (imageView = ((au) findViewWithTag).getImageView()) != null) {
            pVar5 = this.OZ.OT;
            pVar5.setSelectedView(imageView);
            imageView.vq();
        }
        pVar2 = this.OZ.OT;
        int childCount = pVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pVar4 = this.OZ.OT;
            View childAt = pVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof au)) {
                ((au) childAt).qp();
            }
        }
        z = this.OZ.OX;
        if (z && (com.baidu.adp.lib.util.j.fl() || com.baidu.adp.lib.util.j.fi())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                pVar3 = this.OZ.OT;
                View childAt2 = pVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof au)) {
                    z2 = this.OZ.Og;
                    ((au) childAt2).al(z2);
                }
            }
        }
        onPageChangeListener = this.OZ.OU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OZ.OU;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
