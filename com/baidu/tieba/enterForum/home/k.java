package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bi;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ e bGG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.bGG = eVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bGG.YD;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bGG.bGB;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 3 == com.baidu.adp.lib.h.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.tS().getString("wefan_url", "");
            if (!bi.vx().a(this.bGG.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !bi.vx().dK(string)) {
                this.bGG.getBaseFragmentActivity().showToast(t.j.pluginstatus_tip_unknown);
            }
            this.bGG.ho(3);
        } else if (i == 2) {
            TiebaStatic.log("c10584");
            this.bGG.ho(2);
        } else {
            this.bGG.ho(0);
        }
    }
}
