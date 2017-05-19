package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ x bTG;
    private final /* synthetic */ LinkedList bvL;
    private final /* synthetic */ bk bvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(x xVar, LinkedList linkedList, bk bkVar) {
        this.bTG = xVar;
        this.bvL = linkedList;
        this.bvM = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bk bkVar;
        bk bkVar2;
        cd<bk> onSubCardOnClickListenner = this.bTG.getOnSubCardOnClickListenner();
        if (z) {
            if (onSubCardOnClickListenner != null) {
                onSubCardOnClickListenner.aQe = true;
                bkVar2 = this.bTG.ahV;
                onSubCardOnClickListenner.a(view, bkVar2);
            }
            this.bTG.Tj();
            return;
        }
        if (onSubCardOnClickListenner != null) {
            onSubCardOnClickListenner.aQe = false;
            bkVar = this.bTG.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
        this.bTG.a(this.bvL, i, this.bvM);
    }
}
