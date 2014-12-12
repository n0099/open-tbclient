package com.baidu.tbadk.mvc.i.a;

import android.support.v4.view.ViewPager;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.core.tabHost.c {
    final /* synthetic */ a aeK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aeK = aVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.c
    public void c(int i, boolean z) {
        ViewPager viewPager;
        FragmentTabWidget fragmentTabWidget;
        viewPager = this.aeK.aeH;
        viewPager.setCurrentItem(i);
        fragmentTabWidget = this.aeK.aeG;
        fragmentTabWidget.d(i, true);
        this.aeK.aeJ = i;
    }
}
