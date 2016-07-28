package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ ae bMe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.bMe = aeVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.data.ao aoVar;
        if (this.bMe.KN() != null) {
            bx<com.baidu.tbadk.core.data.ao> KN = this.bMe.KN();
            aoVar = this.bMe.bMc;
            KN.a(view, aoVar);
        }
    }
}
