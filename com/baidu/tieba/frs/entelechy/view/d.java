package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bTp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bTp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bi biVar;
        bi biVar2;
        biVar = this.bTp.aiB;
        if (biVar != null && this.bTp.getOnSubCardOnClickListenner() != null) {
            cf<bi> onSubCardOnClickListenner = this.bTp.getOnSubCardOnClickListenner();
            biVar2 = this.bTp.aiB;
            onSubCardOnClickListenner.a(view, biVar2);
        }
    }
}
