package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView amK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MultiImageView multiImageView) {
        this.amK = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amK.amF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amK.amF;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amK.amF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amK.amF;
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
        iVar = this.amK.amE;
        View findViewWithTag = iVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof z) && (imageView = ((z) findViewWithTag).getImageView()) != null) {
            iVar5 = this.amK.amE;
            iVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        iVar2 = this.amK.amE;
        int childCount = iVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            iVar4 = this.amK.amE;
            View childAt = iVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof z)) {
                ((z) childAt).Al();
            }
        }
        z = this.amK.amI;
        if (z && (com.baidu.adp.lib.util.i.iT() || com.baidu.adp.lib.util.i.iQ())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                iVar3 = this.amK.amE;
                View childAt2 = iVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof z)) {
                    z2 = this.amK.alU;
                    ((z) childAt2).aY(z2);
                }
            }
        }
        onPageChangeListener = this.amK.amF;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amK.amF;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
