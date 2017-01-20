package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bxZ;
    private final /* synthetic */ View bya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bxZ = xVar;
        this.bya = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bya != null) {
            this.bya.setVisibility(8);
        }
    }
}
