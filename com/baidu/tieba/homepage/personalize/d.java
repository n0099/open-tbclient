package com.baidu.tieba.homepage.personalize;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ b cAU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cAU = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o oVar;
        o oVar2;
        oVar = this.cAU.cAM;
        if (oVar != null) {
            oVar2 = this.cAU.cAM;
            oVar2.update();
        }
    }
}
