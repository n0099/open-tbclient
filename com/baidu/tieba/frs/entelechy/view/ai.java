package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.cf;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ aa bVP;
    private final /* synthetic */ LinkedList bvN;
    private final /* synthetic */ bi bvO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(aa aaVar, LinkedList linkedList, bi biVar) {
        this.bVP = aaVar;
        this.bvN = linkedList;
        this.bvO = biVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bi biVar;
        bi biVar2;
        cf<bi> onSubCardOnClickListenner = this.bVP.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.aPL = true;
                biVar2 = this.bVP.aiC;
                onSubCardOnClickListenner.a(view, biVar2);
            }
            this.bVP.TR();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.aPL = false;
            biVar = this.bVP.aiC;
            onSubCardOnClickListenner.a(view, biVar);
        }
        this.bVP.a(this.bvN, i, this.bvO);
    }
}
