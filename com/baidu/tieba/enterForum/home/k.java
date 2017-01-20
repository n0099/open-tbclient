package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ f bxz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bxz = fVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bxz.XW;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bxz.bxw;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 1 == com.baidu.adp.lib.g.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.tQ().getString("wefan_url", "");
            if (!ba.vt().a(this.bxz.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !ba.vt().dL(string)) {
                this.bxz.getBaseFragmentActivity().showToast(r.l.pluginstatus_tip_unknown);
            }
            this.bxz.hp(1);
            return;
        }
        this.bxz.hp(0);
    }
}
