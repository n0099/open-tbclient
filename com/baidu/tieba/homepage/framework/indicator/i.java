package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crx.aha()) {
            this.crx.ahc();
            view.setContentDescription("展开");
            return;
        }
        this.crx.ahb();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
