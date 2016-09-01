package com.baidu.tieba.frs.i;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements View.OnClickListener {
    final /* synthetic */ h cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(h hVar) {
        this.cfl = hVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.cfl.afl();
    }
}
