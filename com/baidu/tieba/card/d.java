package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bAC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bAC = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        if (this.bAC.Vs() != null) {
            this.bAC.Vs().a(view, this.bAC.bAA);
        }
        c cVar = this.bAC;
        threadGodReplyLayout = this.bAC.bAw;
        cVar.du(view == threadGodReplyLayout);
    }
}
