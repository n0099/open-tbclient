package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a cvG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.cvG.KN() != null) {
            bx<e> KN = this.cvG.KN();
            eVar = this.cvG.cvF;
            KN.a(view, eVar);
        }
    }
}
