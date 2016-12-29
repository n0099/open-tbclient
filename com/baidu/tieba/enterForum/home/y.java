package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bqm;
    private final /* synthetic */ View bqn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bqm = xVar;
        this.bqn = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bqn != null) {
            this.bqn.setVisibility(8);
        }
    }
}
