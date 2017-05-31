package com.baidu.tieba.homepage.personalize.b;

import android.view.View;
import com.baidu.tieba.homepage.personalize.b.aa;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ aa.a cCp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa.a aVar) {
        this.cCp = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.homepage.personalize.data.h hVar;
        com.baidu.tieba.homepage.personalize.data.h hVar2;
        hVar = this.cCp.cCk;
        if (hVar != null) {
            aa.a aVar = this.cCp;
            hVar2 = this.cCp.cCk;
            aVar.a(hVar2.cCR, view, 2);
        }
    }
}
