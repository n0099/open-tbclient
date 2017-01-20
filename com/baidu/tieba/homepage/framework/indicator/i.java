package com.baidu.tieba.homepage.framework.indicator;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements View.OnClickListener {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuU = scrollFragmentTabHost;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cuU.ajD()) {
            this.cuU.ajE();
            view.setContentDescription("展开");
            return;
        }
        this.cuU.vZ();
        TiebaStatic.log("c10510");
        view.setContentDescription("折叠");
    }
}
