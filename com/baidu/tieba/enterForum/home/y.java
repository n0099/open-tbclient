package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x bEY;
    private final /* synthetic */ View bEZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.bEY = xVar;
        this.bEZ = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bEZ != null) {
            this.bEZ.setVisibility(8);
        }
    }
}
