package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ aa bTy;
    private final /* synthetic */ LinkedList btv;
    private final /* synthetic */ bi btw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar, LinkedList linkedList, bi biVar) {
        this.bTy = aaVar;
        this.btv = linkedList;
        this.btw = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bi biVar;
        bi biVar2;
        cf<bi> onSubCardOnClickListenner = this.bTy.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.aPJ = true;
                biVar2 = this.bTy.aiB;
                onSubCardOnClickListenner.a(view, biVar2);
            }
            this.bTy.SP();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.aPJ = false;
            biVar = this.bTy.aiB;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bTy.a(this.btv, i, this.btw);
    }
}
