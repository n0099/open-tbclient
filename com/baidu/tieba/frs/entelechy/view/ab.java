package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ x bXo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.bXo = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        cd<bi> onSubCardOnClickListenner = this.bXo.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            biVar = this.bXo.adW;
            onSubCardOnClickListenner.a(view, biVar);
        }
    }
}
