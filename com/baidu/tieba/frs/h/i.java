package com.baidu.tieba.frs.h;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements View.OnClickListener {
    final /* synthetic */ e bup;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(e eVar) {
        this.bup = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.bup.PP();
    }
}
