package com.baidu.tieba.graffiti;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnLongClickListener {
    final /* synthetic */ d cpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.cpg = dVar;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.cpg.agK();
        return true;
    }
}
