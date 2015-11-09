package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView akZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MultiImageView multiImageView) {
        this.akZ = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.akZ.akU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.akZ.akU;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.akZ.akU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.akZ.akU;
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
        com.baidu.tbadk.widget.a imageView;
        i iVar5;
        iVar = this.akZ.akT;
        View findViewWithTag = iVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof z) && (imageView = ((z) findViewWithTag).getImageView()) != null) {
            iVar5 = this.akZ.akT;
            iVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        iVar2 = this.akZ.akT;
        int childCount = iVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            iVar4 = this.akZ.akT;
            View childAt = iVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof z)) {
                ((z) childAt).zp();
            }
        }
        z = this.akZ.akX;
        if (z && (com.baidu.adp.lib.util.i.iR() || com.baidu.adp.lib.util.i.iO())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                iVar3 = this.akZ.akT;
                View childAt2 = iVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof z)) {
                    z2 = this.akZ.akj;
                    ((z) childAt2).aT(z2);
                }
            }
        }
        onPageChangeListener = this.akZ.akU;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.akZ.akU;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
