package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements FragmentTabWidget.a {
    final /* synthetic */ e aXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.aXh = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        CustomViewPager customViewPager;
        customViewPager = this.aXh.UR;
        customViewPager.setCurrentItem(i);
        this.aXh.fM(i);
        if (i != 2) {
            if (this.aXh.aWY != null && i == this.aXh.aWY.aYo) {
                TiebaStatic.log("c11148");
                return;
            }
            return;
        }
        TiebaStatic.log("c10584");
    }
}
