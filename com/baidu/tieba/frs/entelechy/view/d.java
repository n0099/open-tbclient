package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a chB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.chB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        bm bmVar2;
        bmVar = this.chB.aiu;
        if (bmVar != null && this.chB.Vs() != null) {
            ci<bm> Vs = this.chB.Vs();
            bmVar2 = this.chB.aiu;
            Vs.a(view, bmVar2);
        }
    }
}
