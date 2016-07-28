package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y bvS;
    private final /* synthetic */ View bvT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, View view) {
        this.bvS = yVar;
        this.bvT = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bvT != null) {
            this.bvT.setVisibility(8);
        }
    }
}
