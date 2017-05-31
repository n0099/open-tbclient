package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ as bZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.bZW = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        if (this.bZW.Ud() != null) {
            this.bZW.Ud().a(view, this.bZW.ahM);
        }
        as asVar = this.bZW;
        threadGodReplyLayout = this.bZW.bzD;
        asVar.dr(view == threadGodReplyLayout);
    }
}
