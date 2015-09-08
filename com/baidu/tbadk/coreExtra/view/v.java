package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView amq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MultiImageView multiImageView) {
        this.amq = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amq.aml;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amq.aml;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.amq.aml;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amq.aml;
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
        iVar = this.amq.amk;
        View findViewWithTag = iVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ab) && (imageView = ((ab) findViewWithTag).getImageView()) != null) {
            iVar5 = this.amq.amk;
            iVar5.setSelectedView(imageView);
            imageView.restoreSize();
        }
        iVar2 = this.amq.amk;
        int childCount = iVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            iVar4 = this.amq.amk;
            View childAt = iVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ab)) {
                ((ab) childAt).zA();
            }
        }
        z = this.amq.amo;
        if (z && (com.baidu.adp.lib.util.i.iP() || com.baidu.adp.lib.util.i.iM())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                iVar3 = this.amq.amk;
                View childAt2 = iVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ab)) {
                    z2 = this.amq.alj;
                    ((ab) childAt2).aZ(z2);
                }
            }
        }
        onPageChangeListener = this.amq.aml;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.amq.aml;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
