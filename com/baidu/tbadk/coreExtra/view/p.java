package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView apx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(MultiImageView multiImageView) {
        this.apx = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.apx.apr;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.apx.apr;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.apx.apr;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.apx.apr;
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
        hVar = this.apx.apq;
        View findViewWithTag = hVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof u)) {
            z3 = this.apx.apw;
            ((u) findViewWithTag).bn(z3);
            com.baidu.tbadk.widget.a imageView = ((u) findViewWithTag).getImageView();
            if (imageView != null) {
                hVar5 = this.apx.apq;
                hVar5.setSelectedView(imageView);
                imageView.GU();
            }
        }
        hVar2 = this.apx.apq;
        int childCount = hVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            hVar4 = this.apx.apq;
            View childAt = hVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof u)) {
                ((u) childAt).Bh();
            }
        }
        z = this.apx.apu;
        if (z && com.baidu.adp.lib.util.i.gm()) {
            for (int i3 = 0; i3 < childCount; i3++) {
                hVar3 = this.apx.apq;
                View childAt2 = hVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof u)) {
                    z2 = this.apx.aoE;
                    ((u) childAt2).br(z2);
                }
            }
        }
        onPageChangeListener = this.apx.apr;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.apx.apr;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
