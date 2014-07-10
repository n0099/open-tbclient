package com.baidu.tbadk.coreExtra.view;

import android.support.v4.view.ViewPager;
import android.view.View;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ViewPager.OnPageChangeListener {
    final /* synthetic */ MultiImageView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(MultiImageView multiImageView) {
        this.a = multiImageView;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrollStateChanged(i);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        onPageChangeListener = this.a.g;
        if (onPageChangeListener != null) {
            onPageChangeListener2 = this.a.g;
            onPageChangeListener2.onPageScrolled(i, f, i2);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        q qVar;
        q qVar2;
        boolean z;
        ViewPager.OnPageChangeListener onPageChangeListener;
        ViewPager.OnPageChangeListener onPageChangeListener2;
        q qVar3;
        boolean z2;
        q qVar4;
        com.baidu.tbadk.widget.a imageView;
        q qVar5;
        qVar = this.a.e;
        View findViewWithTag = qVar.findViewWithTag(String.valueOf(i));
        if (findViewWithTag != null && (findViewWithTag instanceof av) && (imageView = ((av) findViewWithTag).getImageView()) != null) {
            qVar5 = this.a.e;
            qVar5.setSelectedView(imageView);
            imageView.o();
        }
        qVar2 = this.a.e;
        int childCount = qVar2.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            qVar4 = this.a.e;
            View childAt = qVar4.getChildAt(i2);
            if (childAt != null && (childAt instanceof av)) {
                ((av) childAt).e();
            }
        }
        UtilHelper.NetworkStateInfo netStatusInfo = UtilHelper.getNetStatusInfo(this.a.getContext());
        z = this.a.l;
        if (z && (netStatusInfo == UtilHelper.NetworkStateInfo.WIFI || netStatusInfo == UtilHelper.NetworkStateInfo.ThreeG)) {
            for (int i3 = 0; i3 < childCount; i3++) {
                qVar3 = this.a.e;
                View childAt2 = qVar3.getChildAt(i3);
                if (childAt2 != null && (childAt2 instanceof av)) {
                    z2 = this.a.n;
                    ((av) childAt2).a(z2);
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
