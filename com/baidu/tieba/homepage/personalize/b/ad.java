package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ aa.a cKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa.a aVar) {
        this.cKn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.h hVar;
        com.baidu.tieba.homepage.personalize.data.h hVar2;
        hVar = this.cKn.cKi;
        if (hVar != null) {
            aa.a aVar = this.cKn;
            hVar2 = this.cKn.cKi;
            aVar.a(hVar2.cKO, view, 2);
        }
    }
}
