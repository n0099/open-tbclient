package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {
    final /* synthetic */ am bpY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.bpY = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bpY.JO() != null) {
            this.bpY.JO().a(view, this.bpY.aab);
        }
    }
}
