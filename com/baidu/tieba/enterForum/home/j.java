package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.CustomViewPager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements FragmentTabWidget.a {
    final /* synthetic */ e bvs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(e eVar) {
        this.bvs = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        customViewPager = this.bvs.VQ;
        customViewPager.setCurrentItem(i);
        this.bvs.gM(i);
        if (i != 2) {
            if (this.bvs.bvk != null && i == this.bvs.bvk.bwu) {
                TiebaStatic.log("c11148");
                return;
            }
            return;
        }
        TiebaStatic.log("c10584");
    }
}
