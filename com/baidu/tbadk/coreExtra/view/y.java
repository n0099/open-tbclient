package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView alK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MultiImageView multiImageView) {
        this.alK = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.alK.alF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.alK.alF;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.alK.alF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.alK.alF;
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
        iVar = this.alK.alE;
        View findViewWithTag = iVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ae) && (imageView = ((ae) findViewWithTag).getImageView()) != null) {
            iVar5 = this.alK.alE;
            iVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        iVar2 = this.alK.alE;
        int childCount = iVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            iVar4 = this.alK.alE;
            View childAt = iVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ae)) {
                ((ae) childAt).zn();
            }
        }
        z = this.alK.alI;
        if (z && (com.baidu.adp.lib.util.i.iS() || com.baidu.adp.lib.util.i.iP())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                iVar3 = this.alK.alE;
                View childAt2 = iVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ae)) {
                    z2 = this.alK.akR;
                    ((ae) childAt2).aS(z2);
                }
            }
        }
        onPageChangeListener = this.alK.alF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.alK.alF;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
