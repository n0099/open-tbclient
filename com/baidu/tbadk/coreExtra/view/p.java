package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView aoL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MultiImageView multiImageView) {
        this.aoL = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aoL.aoF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aoL.aoF;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.aoL.aoF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aoL.aoF;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        h hVar;
        h hVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        h hVar3;
        boolean z2;
        h hVar4;
        boolean z3;
        h hVar5;
        hVar = this.aoL.aoE;
        View findViewWithTag = hVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof u)) {
            z3 = this.aoL.aoK;
            ((u) findViewWithTag).aW(z3);
            com.baidu.tbadk.widget.a imageView = ((u) findViewWithTag).getImageView();
            if (imageView != null) {
                hVar5 = this.aoL.aoE;
                hVar5.setSelectedView(imageView);
                imageView.restoreSize();
            }
        }
        hVar2 = this.aoL.aoE;
        int childCount = hVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            hVar4 = this.aoL.aoE;
            View childAt = hVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof u)) {
                ((u) childAt).Br();
            }
        }
        z = this.aoL.aoI;
        if (z && (com.baidu.adp.lib.util.i.jd() || com.baidu.adp.lib.util.i.ja())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                hVar3 = this.aoL.aoE;
                View childAt2 = hVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof u)) {
                    z2 = this.aoL.anT;
                    ((u) childAt2).aZ(z2);
                }
            }
        }
        onPageChangeListener = this.aoL.aoF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.aoL.aoF;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
