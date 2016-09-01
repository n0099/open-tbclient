package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cCF.alL()) {
            this.cCF.alN();
            view.setContentDescription("展开");
            return;
        }
        this.cCF.alM();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
