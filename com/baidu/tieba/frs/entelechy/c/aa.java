package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.bpM = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        by<ax> JM = this.bpM.JM();
        if (JM != null) {
            view.setTag("2");
            axVar = this.bpM.aab;
            JM.a(view, axVar);
        }
    }
}
