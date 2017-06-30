package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements View.OnClickListener {
    final /* synthetic */ aw cih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar) {
        this.cih = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ThreadGodReplyLayout threadGodReplyLayout;
        bm bmVar;
        if (this.cih.Vs() != null) {
            ci<bm> Vs = this.cih.Vs();
            bmVar = this.cih.aiu;
            Vs.a(view, bmVar);
        }
        aw awVar = this.cih;
        threadGodReplyLayout = this.cih.bAw;
        awVar.du(view == threadGodReplyLayout);
    }
}
