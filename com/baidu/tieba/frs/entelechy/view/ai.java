package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.cf;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bTK;
    private final /* synthetic */ LinkedList btD;
    private final /* synthetic */ bj btE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar, LinkedList linkedList, bj bjVar) {
        this.bTK = aaVar;
        this.btD = linkedList;
        this.btE = bjVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bj bjVar;
        bj bjVar2;
        cf<bj> onSubCardOnClickListenner = this.bTK.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.aPt = true;
                bjVar2 = this.bTK.ain;
                onSubCardOnClickListenner.a(view, bjVar2);
            }
            this.bTK.Sr();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.aPt = false;
            bjVar = this.bTK.ain;
            onSubCardOnClickListenner.a(view, bjVar);
        }
        this.bTK.a(this.btD, i, this.btE);
    }
}
