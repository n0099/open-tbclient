package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView OV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MultiImageView multiImageView) {
        this.OV = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.OV.OQ;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OV.OQ;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.OV.OQ;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OV.OQ;
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
        pVar = this.OV.OP;
        View findViewWithTag = pVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof au) && (imageView = ((au) findViewWithTag).getImageView()) != null) {
            pVar5 = this.OV.OP;
            pVar5.setSelectedView(imageView);
            imageView.vo();
        }
        pVar2 = this.OV.OP;
        int childCount = pVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            pVar4 = this.OV.OP;
            View childAt = pVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof au)) {
                ((au) childAt).qn();
            }
        }
        z = this.OV.OT;
        if (z && (com.baidu.adp.lib.util.j.fl() || com.baidu.adp.lib.util.j.fi())) {
            for (int i3 = 0; i3 < childCount; i3++) {
                pVar3 = this.OV.OP;
                View childAt2 = pVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof au)) {
                    z2 = this.OV.Oc;
                    ((au) childAt2).al(z2);
                }
            }
        }
        onPageChangeListener = this.OV.OQ;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.OV.OQ;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
