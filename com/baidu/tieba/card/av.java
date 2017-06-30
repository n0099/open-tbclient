package com.baidu.tieba.card;

import android.view.View;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements View.OnClickListener {
    final /* synthetic */ au bCn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(au auVar) {
        this.bCn = auVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        com.baidu.tieba.card.data.l lVar;
        if (this.bCn.Vs() != null) {
            ci<com.baidu.tieba.card.data.l> Vs = this.bCn.Vs();
            lVar = this.bCn.bAA;
            Vs.a(view, lVar);
        }
        au auVar = this.bCn;
        threadGodReplyLayout = this.bCn.bAw;
        auVar.du(view == threadGodReplyLayout);
    }
}
