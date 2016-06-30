package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements View.OnClickListener {
    final /* synthetic */ ak bKJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.bKJ = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bKJ.KO() != null) {
            this.bKJ.KO().a(view, this.bKJ.aas);
        }
    }
}
