package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q chC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.chC = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        if (this.chC.Vs() != null) {
            ci<bm> Vs = this.chC.Vs();
            bmVar = this.chC.aiu;
            Vs.a(view, bmVar);
        }
    }
}
