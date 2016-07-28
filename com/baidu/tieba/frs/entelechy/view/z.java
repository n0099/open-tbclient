package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(v vVar) {
        this.bMb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        bx<be> KN = this.bMb.KN();
        if (KN != null) {
            beVar = this.bMb.abb;
            KN.a(view, beVar);
        }
    }
}
