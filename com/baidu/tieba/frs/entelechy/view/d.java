package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bGf = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bgVar = this.bGf.adN;
        if (bgVar != null && this.bGf.getOnSubCardOnClickListenner() != null) {
            cb<bg> onSubCardOnClickListenner = this.bGf.getOnSubCardOnClickListenner();
            bgVar2 = this.bGf.adN;
            onSubCardOnClickListenner.a(view, bgVar2);
        }
    }
}
