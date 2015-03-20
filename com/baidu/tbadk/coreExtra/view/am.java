package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView afu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MultiImageView multiImageView) {
        this.afu = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.afu.afp;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.afu.afp;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.afu.afp;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.afu.afp;
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
        pVar = this.afu.afo;
        View findViewWithTag = pVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof at) && (imageView = ((at) findViewWithTag).getImageView()) != null) {
            pVar5 = this.afu.afo;
            pVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        pVar2 = this.afu.afo;
        int childCount = pVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pVar4 = this.afu.afo;
            View childAt = pVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof at)) {
                ((at) childAt).xk();
            }
        }
        z = this.afu.afs;
        if (z && (com.baidu.adp.lib.util.k.iL() || com.baidu.adp.lib.util.k.iI())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                pVar3 = this.afu.afo;
                View childAt2 = pVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof at)) {
                    z2 = this.afu.aey;
                    ((at) childAt2).aH(z2);
                }
            }
        }
        onPageChangeListener = this.afu.afp;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.afu.afp;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
