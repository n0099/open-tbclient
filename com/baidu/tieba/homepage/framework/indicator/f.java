package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class f implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cpc = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cpc.agw()) {
            this.cpc.agy();
            view.setContentDescription("展开");
            return;
        }
        this.cpc.agx();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
