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
    private final /* synthetic */ int aak;
    final /* synthetic */ PagerSlidingTabStrip ctN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PagerSlidingTabStrip pagerSlidingTabStrip, int i) {
        this.ctN = pagerSlidingTabStrip;
        this.aak = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z;
        z = this.ctN.isLoading;
        if (!z) {
            if (this.ctN.akE.getCurrentItem() == this.aak) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK, 0));
                return;
            }
            TiebaStatic.log(new as("c12049").s("obj_locate", this.aak + 1).aa("obj_type", "1"));
            this.ctN.ctM = true;
            if (this.ctN.akE.getAdapter() instanceof a) {
                ((a) this.ctN.akE.getAdapter()).jJ(this.aak);
            }
            this.ctN.akE.setCurrentItem(this.aak);
            this.ctN.wj();
        }
    }
}
