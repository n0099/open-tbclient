package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.tabHost.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements d {
    final /* synthetic */ a afh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afh = aVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.d
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.afh.afe;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.afh.afd;
        fragmentTabWidget.d(i, true);
        this.afh.afg = i;
    }
}
