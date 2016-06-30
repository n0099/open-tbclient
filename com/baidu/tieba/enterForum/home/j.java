package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements FragmentTabWidget.a {
    final /* synthetic */ e btd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.btd = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void e(int i, boolean z) {
        CustomViewPager customViewPager;
        customViewPager = this.btd.Vh;
        customViewPager.setCurrentItem(i);
        this.btd.gM(i);
        if (i != 2) {
            if (this.btd.bsV != null && i == this.btd.bsV.bug) {
                TiebaStatic.log("c11148");
                return;
            }
            return;
        }
        TiebaStatic.log("c10584");
    }
}
