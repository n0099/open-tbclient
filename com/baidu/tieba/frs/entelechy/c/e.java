package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ a bpG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.bpG = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ax axVar;
        ax axVar2;
        axVar = this.bpG.aab;
        if (axVar != null && this.bpG.JM() != null) {
            by<ax> JM = this.bpG.JM();
            axVar2 = this.bpG.aab;
            JM.a(view, axVar2);
        }
    }
}
