package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i csU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.csU = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.csU.getOnSubCardOnClickListenner() != null) {
            cd<h> onSubCardOnClickListenner = this.csU.getOnSubCardOnClickListenner();
            hVar = this.csU.csT;
            onSubCardOnClickListenner.a(view, hVar);
        }
    }
}
