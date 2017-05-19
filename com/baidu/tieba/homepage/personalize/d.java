package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cuC = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        o oVar2;
        oVar = this.cuC.cuu;
        if (oVar != null) {
            oVar2 = this.cuC.cuu;
            oVar2.update();
        }
    }
}
