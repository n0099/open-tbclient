package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        n nVar;
        n nVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        n nVar3;
        boolean z2;
        n nVar4;
        com.baidu.tbadk.widget.a imageView;
        n nVar5;
        com.baidu.adp.lib.util.f.e(getClass().getName(), "onPageSelected", "postion = " + String.valueOf(i));
        nVar = this.a.e;
        View findViewWithTag = nVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof ah) && (imageView = ((ah) findViewWithTag).getImageView()) != null) {
            nVar5 = this.a.e;
            nVar5.setSelectedView(imageView);
            imageView.n();
        }
        nVar2 = this.a.e;
        int childCount = nVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            nVar4 = this.a.e;
            View childAt = nVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof ah)) {
                ((ah) childAt).c();
            }
        }
        UtilHelper.NetworkStateInfo d = UtilHelper.d(this.a.getContext());
        z = this.a.l;
        if (z && (d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                nVar3 = this.a.e;
                View childAt2 = nVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof ah)) {
                    z2 = this.a.n;
                    ((ah) childAt2).a(z2);
                }
            }
        }
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageSelected(i);
        }
    }
}
