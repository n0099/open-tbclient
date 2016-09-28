package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bXh = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        biVar = this.bXh.adW;
        if (biVar != null && this.bXh.getOnSubCardOnClickListenner() != null) {
            cd<bi> onSubCardOnClickListenner = this.bXh.getOnSubCardOnClickListenner();
            biVar2 = this.bXh.adW;
            onSubCardOnClickListenner.a(view, biVar2);
        }
    }
}
