package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e ctE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ctE = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.ctE.getOnSubCardOnClickListenner() != null) {
            cf<d> onSubCardOnClickListenner = this.ctE.getOnSubCardOnClickListenner();
            dVar = this.ctE.ctD;
            onSubCardOnClickListenner.a(view, dVar);
        }
    }
}
