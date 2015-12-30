package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView anU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MultiImageView multiImageView) {
        this.anU = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.anU.anO;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.anU.anO;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.anU.anO;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.anU.anO;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        i iVar;
        i iVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        i iVar3;
        boolean z2;
        i iVar4;
        boolean z3;
        i iVar5;
        iVar = this.anU.anN;
        View findViewWithTag = iVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof z)) {
            z3 = this.anU.anT;
            ((z) findViewWithTag).aU(z3);
            com.baidu.tbadk.widget.a imageView = ((z) findViewWithTag).getImageView();
            if (imageView != null) {
                iVar5 = this.anU.anN;
                iVar5.setSelectedView(imageView);
                imageView.restoreSize();
            }
        }
        iVar2 = this.anU.anN;
        int childCount = iVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            iVar4 = this.anU.anN;
            View childAt = iVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof z)) {
                ((z) childAt).Ab();
            }
        }
        z = this.anU.anR;
        if (z && (com.baidu.adp.lib.util.i.iU() || com.baidu.adp.lib.util.i.iR())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                iVar3 = this.anU.anN;
                View childAt2 = iVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof z)) {
                    z2 = this.anU.ana;
                    ((z) childAt2).aX(z2);
                }
            }
        }
        onPageChangeListener = this.anU.anO;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.anU.anO;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
