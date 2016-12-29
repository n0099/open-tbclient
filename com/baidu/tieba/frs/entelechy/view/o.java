package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bGf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        if (this.bGf.getOnSubCardOnClickListenner() != null) {
            cb<bg> onSubCardOnClickListenner = this.bGf.getOnSubCardOnClickListenner();
            bgVar = this.bGf.adN;
            onSubCardOnClickListenner.a(view, bgVar);
        }
    }
}
