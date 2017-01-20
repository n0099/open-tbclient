package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.cf;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bMC;
    private final /* synthetic */ LinkedList bmI;
    private final /* synthetic */ bh bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar, LinkedList linkedList, bh bhVar) {
        this.bMC = aaVar;
        this.bmI = linkedList;
        this.bmJ = bhVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bh bhVar;
        bh bhVar2;
        cf<bh> onSubCardOnClickListenner = this.bMC.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.aJK = true;
                bhVar2 = this.bMC.acX;
                onSubCardOnClickListenner.a(view, bhVar2);
            }
            this.bMC.Rt();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.aJK = false;
            bhVar = this.bMC.acX;
            onSubCardOnClickListenner.a(view, bhVar);
        }
        this.bMC.a(this.bmI, i, this.bmJ);
    }
}
