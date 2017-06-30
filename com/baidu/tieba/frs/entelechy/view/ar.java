package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao cif;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.cif = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cif.Vs() != null) {
            this.cif.Vs().a(view, this.cif.aiu);
        }
    }
}
