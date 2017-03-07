package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ f bEF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bEF = fVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bEF.adl;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bEF.bEC;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 1 == com.baidu.adp.lib.g.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.uo().getString("wefan_url", "");
            if (!bb.vQ().a(this.bEF.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !bb.vQ().dF(string)) {
                this.bEF.getBaseFragmentActivity().showToast(w.l.pluginstatus_tip_unknown);
            }
            this.bEF.hl(1);
            return;
        }
        this.bEF.hl(0);
    }
}
