package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cwL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cwL = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cwL.getOnSubCardOnClickListenner() != null) {
            cd<e> onSubCardOnClickListenner = this.cwL.getOnSubCardOnClickListenner();
            eVar = this.cwL.cwK;
            onSubCardOnClickListenner.a(view, eVar);
        }
    }
}
