package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x chH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.chH = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        if (this.chH.Vs() != null) {
            ci<bm> Vs = this.chH.Vs();
            bmVar = this.chH.aiu;
            Vs.a(view, bmVar);
        }
        this.chH.VI();
    }
}
