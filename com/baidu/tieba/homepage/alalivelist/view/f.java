package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e csS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.csS = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.csS.getOnSubCardOnClickListenner() != null) {
            cd<d> onSubCardOnClickListenner = this.csS.getOnSubCardOnClickListenner();
            dVar = this.csS.csR;
            onSubCardOnClickListenner.a(view, dVar);
        }
    }
}
