package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView Vq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.Vq = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.Vq.Vl;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.Vq.Vl;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.Vq.Vl;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.Vq.Vl;
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
        pVar = this.Vq.Vk;
        View findViewWithTag = pVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ax) && (imageView = ((ax) findViewWithTag).getImageView()) != null) {
            pVar5 = this.Vq.Vk;
            pVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        pVar2 = this.Vq.Vk;
        int childCount = pVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pVar4 = this.Vq.Vk;
            View childAt = pVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ax)) {
                ((ax) childAt).tZ();
            }
        }
        z = this.Vq.Vo;
        if (z && (com.baidu.adp.lib.util.i.fj() || com.baidu.adp.lib.util.i.fg())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                pVar3 = this.Vq.Vk;
                View childAt2 = pVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ax)) {
                    z2 = this.Vq.Uy;
                    ((ax) childAt2).aB(z2);
                }
            }
        }
        onPageChangeListener = this.Vq.Vl;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.Vq.Vl;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
