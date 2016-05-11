package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {
    final /* synthetic */ s bpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar) {
        this.bpI = sVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        if (this.bpI.JM() != null) {
            by<ax> JM = this.bpI.JM();
            axVar = this.bpI.aab;
            JM.a(view, axVar);
        }
    }
}
