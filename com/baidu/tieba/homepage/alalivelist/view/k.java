package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cvX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cvX = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.cvX.getOnSubCardOnClickListenner() != null) {
            cf<h> onSubCardOnClickListenner = this.cvX.getOnSubCardOnClickListenner();
            hVar = this.cvX.cvW;
            onSubCardOnClickListenner.a(view, hVar);
        }
    }
}
