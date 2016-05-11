package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar) {
        this.bpG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        if (this.bpG.JM() != null) {
            by<ax> JM = this.bpG.JM();
            axVar = this.bpG.aab;
            JM.a(view, axVar);
        }
    }
}
