package com.baidu.tieba.frs.entelechy.c;

import android.view.View;
import com.baidu.tbadk.core.data.ax;
import com.baidu.tieba.card.by;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList aQw;
    private final /* synthetic */ ax aQx;
    final /* synthetic */ w bpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar, LinkedList linkedList, ax axVar) {
        this.bpM = wVar;
        this.aQw = linkedList;
        this.aQx = axVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        ax axVar;
        by<ax> JM = this.bpM.JM();
        if (JM != null) {
            view.setTag("1");
            axVar = this.bpM.aab;
            JM.a(view, axVar);
        }
        if (!z) {
            this.bpM.a(this.aQw, i, this.aQx);
        } else {
            this.bpM.Kd();
        }
    }
}
