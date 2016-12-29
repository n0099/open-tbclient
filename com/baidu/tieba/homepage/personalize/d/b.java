package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import com.baidu.tieba.card.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cst;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cst = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cst.getOnSubCardOnClickListenner() != null) {
            cb<e> onSubCardOnClickListenner = this.cst.getOnSubCardOnClickListenner();
            eVar = this.cst.css;
            onSubCardOnClickListenner.a(view, eVar);
        }
    }
}
