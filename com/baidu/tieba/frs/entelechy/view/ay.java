package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ay implements View.OnClickListener {
    final /* synthetic */ aw cih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(aw awVar) {
        this.cih = awVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        bm bmVar;
        ci<bm> Vs = this.cih.Vs();
        if (Vs != null) {
            view.setTag("2");
            bmVar = this.cih.aiu;
            Vs.a(view, bmVar);
        }
    }
}
