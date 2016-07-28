package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.widget.layout.h {
    private final /* synthetic */ LinkedList aUP;
    private final /* synthetic */ be aUQ;
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(v vVar, LinkedList linkedList, be beVar) {
        this.bMb = vVar;
        this.aUP = linkedList;
        this.aUQ = beVar;
    }

    @Override // com.baidu.tbadk.widget.layout.h
    public void c(View view, int i, boolean z) {
        be beVar;
        be beVar2;
        bx<be> KN = this.bMb.KN();
        if (z) {
            if (KN != null) {
                KN.aVK = true;
                beVar2 = this.bMb.abb;
                KN.a(view, beVar2);
            }
            this.bMb.Lc();
            return;
        }
        if (KN != null) {
            KN.aVK = false;
            beVar = this.bMb.abb;
            KN.a(view, beVar);
        }
        this.bMb.a(this.aUP, i, this.aUQ);
    }
}
