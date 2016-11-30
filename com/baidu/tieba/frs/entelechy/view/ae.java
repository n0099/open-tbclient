package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.bz;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList bdB;
    private final /* synthetic */ bk bdC;
    final /* synthetic */ w caE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(w wVar, LinkedList linkedList, bk bkVar) {
        this.caE = wVar;
        this.bdB = linkedList;
        this.bdC = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        bk bkVar;
        bk bkVar2;
        bz<bk> onSubCardOnClickListenner = this.caE.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.beK = true;
                bkVar2 = this.caE.aeu;
                onSubCardOnClickListenner.a(view, bkVar2);
            }
            this.caE.Ph();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.beK = false;
            bkVar = this.caE.aeu;
            onSubCardOnClickListenner.a(view, bkVar);
        }
        this.caE.a(this.bdB, i, this.bdC);
    }
}
