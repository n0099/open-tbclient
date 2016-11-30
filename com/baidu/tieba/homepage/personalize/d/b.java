package com.baidu.tieba.homepage.personalize.d;

import android.view.View;
import com.baidu.tieba.card.bz;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cNo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cNo = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cNo.getOnSubCardOnClickListenner() != null) {
            bz<e> onSubCardOnClickListenner = this.cNo.getOnSubCardOnClickListenner();
            eVar = this.cNo.cNn;
            onSubCardOnClickListenner.a(view, eVar);
        }
    }
}
