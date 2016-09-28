package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ x bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar) {
        this.bXo = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        if (this.bXo.getOnSubCardOnClickListenner() != null) {
            cd<bi> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
            biVar = this.bXo.adW;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bXo.Of();
    }
}
