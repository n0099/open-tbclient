package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bFf;
    private final /* synthetic */ View bFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bFf = xVar;
        this.bFg = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bFg != null) {
            this.bFg.setVisibility(8);
        }
    }
}
