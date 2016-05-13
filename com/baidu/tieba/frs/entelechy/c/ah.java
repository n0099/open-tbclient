package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ af bpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(af afVar) {
        this.bpP = afVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ag agVar;
        if (this.bpP.JO() != null) {
            by<com.baidu.tbadk.core.data.ag> JO = this.bpP.JO();
            agVar = this.bpP.bpN;
            JO.a(view, agVar);
        }
    }
}
