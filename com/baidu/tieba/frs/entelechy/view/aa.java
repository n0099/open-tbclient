package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ x chH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar) {
        this.chH = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        ci<bm> Vs = this.chH.Vs();
        if (Vs != null) {
            bmVar = this.chH.aiu;
            Vs.a(view, bmVar);
        }
    }
}
