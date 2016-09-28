package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ f bGP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bGP = fVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bGP.YQ;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bGP.bGM;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 1 == com.baidu.adp.lib.h.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.uh().getString("wefan_url", "");
            if (!bh.vL().a(this.bGP.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !bh.vL().dN(string)) {
                this.bGP.getBaseFragmentActivity().showToast(r.j.pluginstatus_tip_unknown);
            }
            this.bGP.hs(1);
            return;
        }
        this.bGP.hs(0);
    }
}
