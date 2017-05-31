package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements View.OnClickListener {
    final /* synthetic */ ai bZG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar) {
        this.bZG = aiVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ax axVar;
        if (this.bZG.Ud() != null) {
            ci<com.baidu.tbadk.core.data.ax> Ud = this.bZG.Ud();
            axVar = this.bZG.bZE;
            Ud.a(view, axVar);
        }
    }
}
