package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements View.OnClickListener {
    final /* synthetic */ e cGW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.cGW = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (this.cGW.Vs() != null) {
            ci<d> Vs = this.cGW.Vs();
            dVar = this.cGW.cGV;
            Vs.a(view, dVar);
        }
    }
}
