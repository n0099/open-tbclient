package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bVG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bVG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        biVar = this.bVG.aiC;
        if (biVar != null && this.bVG.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bVG.getOnSubCardOnClickListenner();
            biVar2 = this.bVG.aiC;
            onSubCardOnClickListenner.a(view, biVar2);
        }
    }
}
