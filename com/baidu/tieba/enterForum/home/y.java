package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bHp;
    private final /* synthetic */ View bHq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bHp = xVar;
        this.bHq = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bHq != null) {
            this.bHq.setVisibility(8);
        }
    }
}
