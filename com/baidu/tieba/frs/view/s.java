package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q cfU;
    private final /* synthetic */ q.b cfV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.cfU = qVar;
        this.cfV = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.cfU.cfP;
        if (aVar != null) {
            aVar2 = this.cfU.cfP;
            aVar2.iC(this.cfV.cfW);
        }
        this.cfU.dismiss();
    }
}
