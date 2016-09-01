package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bXm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bXm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bg bgVar;
        bg bgVar2;
        bgVar = this.bXm.adL;
        if (bgVar != null && this.bXm.getOnSubCardOnClickListenner() != null) {
            cf<bg> onSubCardOnClickListenner = this.bXm.getOnSubCardOnClickListenner();
            bgVar2 = this.bXm.adL;
            onSubCardOnClickListenner.a(view, bgVar2);
        }
    }
}
