package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(w wVar) {
        this.bpM = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        if (this.bpM.JM() != null) {
            by<ax> JM = this.bpM.JM();
            axVar = this.bpM.aab;
            JM.a(view, axVar);
        }
    }
}
