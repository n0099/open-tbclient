package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(u uVar) {
        this.bKt = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        bx<az> KO = this.bKt.KO();
        if (KO != null) {
            view.setTag("2");
            azVar = this.bKt.aas;
            KO.a(view, azVar);
        }
    }
}
