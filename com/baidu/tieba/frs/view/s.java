package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q ceu;
    private final /* synthetic */ q.b cev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.ceu = qVar;
        this.cev = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.ceu.cep;
        if (aVar != null) {
            aVar2 = this.ceu.cep;
            aVar2.iD(this.cev.cew);
        }
        this.ceu.dismiss();
    }
}
