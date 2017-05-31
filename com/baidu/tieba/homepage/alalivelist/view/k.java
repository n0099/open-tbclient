package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i czm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.czm = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.czm.Ud() != null) {
            ci<h> Ud = this.czm.Ud();
            hVar = this.czm.czl;
            Ud.a(view, hVar);
        }
    }
}
