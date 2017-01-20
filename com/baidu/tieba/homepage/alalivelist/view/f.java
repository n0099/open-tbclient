package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e ctF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ctF = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.ctF.getOnSubCardOnClickListenner() != null) {
            cf<d> onSubCardOnClickListenner = this.ctF.getOnSubCardOnClickListenner();
            dVar = this.ctF.ctE;
            onSubCardOnClickListenner.a(view, dVar);
        }
    }
}
