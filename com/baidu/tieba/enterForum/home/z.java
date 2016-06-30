package com.baidu.tieba.enterForum.home;

import android.view.View;
/* loaded from: classes.dex */
class z implements View.OnClickListener {
    final /* synthetic */ y btE;
    private final /* synthetic */ View btF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, View view) {
        this.btE = yVar;
        this.btF = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.btF != null) {
            this.btF.setVisibility(8);
        }
    }
}
