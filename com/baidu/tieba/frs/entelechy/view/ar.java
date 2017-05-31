package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnClickListener {
    final /* synthetic */ ao bZV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ao aoVar) {
        this.bZV = aoVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bZV.Ud() != null) {
            this.bZV.Ud().a(view, this.bZV.ahM);
        }
    }
}
