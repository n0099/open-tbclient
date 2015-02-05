package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.tabHost.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements d {
    final /* synthetic */ a afe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afe = aVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.afe.afb;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.afe.afa;
        fragmentTabWidget.d(i, true);
        this.afe.afd = i;
    }
}
