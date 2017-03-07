package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements View.OnClickListener {
    final /* synthetic */ i cvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.cvg = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.cvg.getOnSubCardOnClickListenner() != null) {
            cf<h> onSubCardOnClickListenner = this.cvg.getOnSubCardOnClickListenner();
            hVar = this.cvg.cvf;
            onSubCardOnClickListenner.a(view, hVar);
        }
    }
}
