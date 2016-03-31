package com.baidu.tieba.card;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements View.OnClickListener {
    final /* synthetic */ ay aTS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ay ayVar) {
        this.aTS = ayVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.t tVar;
        if (this.aTS.Ld() != null) {
            cj<com.baidu.tieba.card.a.t> Ld = this.aTS.Ld();
            tVar = this.aTS.aTR;
            Ld.a(view, tVar);
        }
    }
}
