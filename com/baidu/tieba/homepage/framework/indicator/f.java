package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ int aak;
    final /* synthetic */ PagerSlidingTabStrip cHR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.cHR = pagerSlidingTabStrip;
        this.aak = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.cHR.isLoading;
        if (!z) {
            if (this.cHR.alh.getCurrentItem() == this.aak) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                return;
            }
            TiebaStatic.log(new au("c12049").r("obj_locate", this.aak + 1).Z("obj_type", "1"));
            this.cHR.cHQ = true;
            if (this.cHR.alh.getAdapter() instanceof a) {
                ((a) this.cHR.alh.getAdapter()).kt(this.aak);
            }
            this.cHR.alh.setCurrentItem(this.aak);
            this.cHR.wy();
        }
    }
}
