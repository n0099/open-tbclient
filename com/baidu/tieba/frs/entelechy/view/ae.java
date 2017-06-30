package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.ci;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.g {
    private final /* synthetic */ LinkedList bCo;
    private final /* synthetic */ bm bCp;
    final /* synthetic */ x chH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar, LinkedList linkedList, bm bmVar) {
        this.chH = xVar;
        this.bCo = linkedList;
        this.bCp = bmVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bm bmVar;
        bm bmVar2;
        ci<bm> Vs = this.chH.Vs();
        if (z) {
            if (Vs != null) {
                Vs.aRx = true;
                bmVar2 = this.chH.aiu;
                Vs.a(view, bmVar2);
            }
            this.chH.VI();
            return;
        }
        if (Vs != null) {
            Vs.aRx = false;
            bmVar = this.chH.aiu;
            Vs.a(view, bmVar);
        }
        this.chH.a(this.bCo, i, this.bCp);
    }
}
