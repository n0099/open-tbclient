package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements FragmentTabWidget.a {
    final /* synthetic */ e aWp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.aWp = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void c(int i, boolean z) {
        CustomViewPager customViewPager;
        customViewPager = this.aWp.aam;
        customViewPager.setCurrentItem(i);
        this.aWp.fQ(i);
        if (i == 1) {
            TiebaStatic.log("c10584");
        }
    }
}
