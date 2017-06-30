package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cLa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cLa = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cLa.Vs() != null) {
            ci<e> Vs = this.cLa.Vs();
            eVar = this.cLa.cKZ;
            Vs.a(view, eVar);
        }
    }
}
