package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ c bzJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bzJ = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        if (this.bzJ.Ud() != null) {
            this.bzJ.Ud().a(view, this.bzJ.bzH);
        }
        c cVar = this.bzJ;
        threadGodReplyLayout = this.bzJ.bzD;
        cVar.dr(view == threadGodReplyLayout);
    }
}
