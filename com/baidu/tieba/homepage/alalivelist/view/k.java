package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i ctH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.ctH = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.ctH.getOnSubCardOnClickListenner() != null) {
            cf<h> onSubCardOnClickListenner = this.ctH.getOnSubCardOnClickListenner();
            hVar = this.ctH.ctG;
            onSubCardOnClickListenner.a(view, hVar);
        }
    }
}
