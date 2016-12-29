package com.baidu.tieba.enterForum.home;

import android.view.View;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements FragmentTabWidget.a {
    final /* synthetic */ f bpN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(f fVar) {
        this.bpN = fVar;
    }

    @Override // com.baidu.tbadk.core.tabHost.FragmentTabWidget.a
    public void f(int i, boolean z) {
        CustomViewPager customViewPager;
        FragmentTabWidget fragmentTabWidget;
        customViewPager = this.bpN.YI;
        customViewPager.setCurrentItem(i);
        fragmentTabWidget = this.bpN.bpK;
        View childAt = fragmentTabWidget.getChildAt(i);
        if (childAt.getTag() != null && 1 == com.baidu.adp.lib.h.b.g(String.valueOf(childAt.getTag()), 0)) {
            String string = com.baidu.tbadk.core.sharedPref.b.tW().getString("wefan_url", "");
            if (!bc.vz().a(this.bpN.getBaseFragmentActivity().getPageContext(), "", new String[]{string}, false, null, true) && !bc.vz().dN(string)) {
                this.bpN.getBaseFragmentActivity().showToast(r.j.pluginstatus_tip_unknown);
            }
            this.bpN.gD(1);
            return;
        }
        this.bpN.gD(0);
    }
}
