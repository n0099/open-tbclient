package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    private final /* synthetic */ int aaj;
    final /* synthetic */ PagerSlidingTabStrip cAf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.cAf = pagerSlidingTabStrip;
        this.aaj = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.cAf.isLoading;
        if (!z) {
            if (this.cAf.aku.getCurrentItem() == this.aaj) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                return;
            }
            TiebaStatic.log(new as("c12049").r("obj_locate", this.aaj + 1).Z("obj_type", "1"));
            this.cAf.cAe = true;
            if (this.cAf.aku.getAdapter() instanceof a) {
                ((a) this.cAf.aku.getAdapter()).ki(this.aaj);
            }
            this.cAf.aku.setCurrentItem(this.aaj);
            this.cAf.wg();
        }
    }
}
