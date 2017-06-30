package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements View.OnClickListener {
    final /* synthetic */ as cig;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(as asVar) {
        this.cig = asVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        if (this.cig.Vs() != null) {
            this.cig.Vs().a(view, this.cig.aiu);
        }
        as asVar = this.cig;
        threadGodReplyLayout = this.cig.bAw;
        asVar.du(view == threadGodReplyLayout);
    }
}
