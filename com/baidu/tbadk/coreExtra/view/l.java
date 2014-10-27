package com.baidu.tbadk.coreExtra.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ j NP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.NP = jVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.NP.o(view);
    }
}
