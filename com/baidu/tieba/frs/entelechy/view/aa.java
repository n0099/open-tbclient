package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ v bMb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(v vVar) {
        this.bMb = vVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        be beVar;
        if (this.bMb.KN() != null) {
            bx<be> KN = this.bMb.KN();
            beVar = this.bMb.abb;
            KN.a(view, beVar);
        }
    }
}
