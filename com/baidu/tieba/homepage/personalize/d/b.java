package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import com.baidu.tieba.card.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cHZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cHZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cHZ.getOnSubCardOnClickListenner() != null) {
            cd<e> onSubCardOnClickListenner = this.cHZ.getOnSubCardOnClickListenner();
            eVar = this.cHZ.cHY;
            onSubCardOnClickListenner.a(view, eVar);
        }
    }
}
