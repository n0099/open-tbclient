package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ f bJJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bJJ = fVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bJJ.Zo;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bJJ.bJG;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 1 == com.baidu.adp.lib.h.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.um().getString("wefan_url", "");
            if (!bf.vP().a(this.bJJ.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !bf.vP().dP(string)) {
                this.bJJ.getBaseFragmentActivity().showToast(r.j.pluginstatus_tip_unknown);
            }
            this.bJJ.ht(1);
            return;
        }
        this.bJJ.ht(0);
    }
}
