package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.cb;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.widget.layout.h {
    final /* synthetic */ aa bGn;
    private final /* synthetic */ LinkedList bcT;
    private final /* synthetic */ bg bcU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar, LinkedList linkedList, bg bgVar) {
        this.bGn = aaVar;
        this.bcT = linkedList;
        this.bcU = bgVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bg bgVar;
        bg bgVar2;
        cb<bg> onSubCardOnClickListenner = this.bGn.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.beb = true;
                bgVar2 = this.bGn.adN;
                onSubCardOnClickListenner.a(view, bgVar2);
            }
            this.bGn.OD();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.beb = false;
            bgVar = this.bGn.adN;
            onSubCardOnClickListenner.a(view, bgVar);
        }
        this.bGn.a(this.bcT, i, this.bcU);
    }
}
