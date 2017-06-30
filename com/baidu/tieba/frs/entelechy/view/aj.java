package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai chP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.chP = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ay ayVar;
        if (this.chP.Vs() != null) {
            ci<com.baidu.tbadk.core.data.ay> Vs = this.chP.Vs();
            ayVar = this.chP.chN;
            Vs.a(view, ayVar);
        }
    }
}
