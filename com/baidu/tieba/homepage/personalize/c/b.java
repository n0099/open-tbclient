package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a czy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.czy = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.czy.getOnSubCardOnClickListenner() != null) {
            cf<e> onSubCardOnClickListenner = this.czy.getOnSubCardOnClickListenner();
            eVar = this.czy.czx;
            onSubCardOnClickListenner.a(view, eVar);
        }
    }
}
