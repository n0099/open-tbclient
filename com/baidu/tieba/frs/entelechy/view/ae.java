package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {
    final /* synthetic */ aa bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(aa aaVar) {
        this.bGn = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        cb<bg> onSubCardOnClickListenner = this.bGn.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            bgVar = this.bGn.adN;
            onSubCardOnClickListenner.a(view, bgVar);
        }
    }
}
