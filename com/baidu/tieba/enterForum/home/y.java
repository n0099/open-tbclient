package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bHo;
    private final /* synthetic */ View bHp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bHo = xVar;
        this.bHp = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bHp != null) {
            this.bHp.setVisibility(8);
        }
    }
}
