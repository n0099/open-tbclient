package com.baidu.tieba.homepage.personalize.c;

import android.view.View;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a csV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.csV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        e eVar;
        if (this.csV.KO() != null) {
            bx<e> KO = this.csV.KO();
            eVar = this.csV.csU;
            KO.a(view, eVar);
        }
    }
}
