package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.cd;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.tbadk.widget.layout.g {
    final /* synthetic */ as bUd;
    private final /* synthetic */ LinkedList bvL;
    private final /* synthetic */ bk bvM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(as asVar, LinkedList linkedList, bk bkVar) {
        this.bUd = asVar;
        this.bvL = linkedList;
        this.bvM = bkVar;
    }

    @Override // com.baidu.tbadk.widget.layout.g
    public void c(View view, int i, boolean z) {
        bk bkVar;
        cd<bk> onSubCardOnClickListenner = this.bUd.getOnSubCardOnClickListenner();
        if (onSubCardOnClickListenner != null) {
            view.setTag("1");
            bkVar = this.bUd.ahV;
            onSubCardOnClickListenner.a(view, bkVar);
        }
        if (!z) {
            this.bUd.a(this.bvL, i, this.bvM);
        } else {
            this.bUd.da(false);
        }
    }
}
