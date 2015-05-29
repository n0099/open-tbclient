package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ a aoJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aoJ = aVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.aoJ.aoG;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.aoJ.aoF;
        fragmentTabWidget.d(i, true);
        this.aoJ.aoI = i;
    }
}
