package com.baidu.tieba.frs.entelechy.view;

import android.view.View;
import com.baidu.tbadk.core.data.az;
import com.baidu.tieba.card.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {
    final /* synthetic */ u bKt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar) {
        this.bKt = uVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        az azVar;
        if (this.bKt.KO() != null) {
            bx<az> KO = this.bKt.KO();
            azVar = this.bKt.aas;
            KO.a(view, azVar);
        }
        this.bKt.Ld();
    }
}
