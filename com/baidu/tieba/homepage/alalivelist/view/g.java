package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements View.OnClickListener {
    final /* synthetic */ e cvV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(e eVar) {
        this.cvV = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.cvV.getOnSubCardOnClickListenner() != null) {
            cf<d> onSubCardOnClickListenner = this.cvV.getOnSubCardOnClickListenner();
            dVar = this.cvV.cvU;
            onSubCardOnClickListenner.a(view, dVar);
        }
    }
}
