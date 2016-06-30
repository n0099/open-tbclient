package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ q bKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.bKp = qVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        if (this.bKp.KO() != null) {
            bx<az> KO = this.bKp.KO();
            azVar = this.bKp.aas;
            KO.a(view, azVar);
        }
    }
}
