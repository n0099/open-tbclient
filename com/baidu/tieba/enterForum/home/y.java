package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ x aWR;
    private final /* synthetic */ View aWS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, View view) {
        this.aWR = xVar;
        this.aWS = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aWS != null) {
            this.aWS.setVisibility(8);
        }
    }
}
