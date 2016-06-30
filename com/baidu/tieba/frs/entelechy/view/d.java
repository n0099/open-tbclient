package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements View.OnClickListener {
    final /* synthetic */ a bKn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.bKn = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        az azVar2;
        azVar = this.bKn.aas;
        if (azVar != null && this.bKn.KO() != null) {
            bx<az> KO = this.bKn.KO();
            azVar2 = this.bKn.aas;
            KO.a(view, azVar2);
        }
    }
}
