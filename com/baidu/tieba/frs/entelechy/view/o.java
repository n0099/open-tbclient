package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ a bXh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.bXh = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bXh.getOnSubCardOnClickListenner() != null) {
            cd<bi> onSubCardOnClickListenner = this.bXh.getOnSubCardOnClickListenner();
            biVar = this.bXh.adW;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
