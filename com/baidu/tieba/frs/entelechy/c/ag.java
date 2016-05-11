package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ af bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bpP = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ag agVar;
        if (this.bpP.JM() != null) {
            by<com.baidu.tbadk.core.data.ag> JM = this.bpP.JM();
            agVar = this.bpP.bpN;
            JM.a(view, agVar);
        }
    }
}
