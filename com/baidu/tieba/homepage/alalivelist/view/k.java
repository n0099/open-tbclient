package com.baidu.tieba.homepage.alalivelist.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ i cGY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar) {
        this.cGY = iVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        h hVar;
        if (this.cGY.Vs() != null) {
            ci<h> Vs = this.cGY.Vs();
            hVar = this.cGY.cGX;
            Vs.a(view, hVar);
        }
    }
}
