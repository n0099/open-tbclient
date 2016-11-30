package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bKi;
    private final /* synthetic */ View bKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bKi = xVar;
        this.bKj = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bKj != null) {
            this.bKj.setVisibility(8);
        }
    }
}
