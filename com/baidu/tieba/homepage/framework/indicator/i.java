package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxk = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cxk.ajL()) {
            this.cxk.wS();
            view.setContentDescription("展开");
            return;
        }
        this.cxk.wR();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
