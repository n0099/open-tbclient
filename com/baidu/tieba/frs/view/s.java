package com.baidu.tieba.frs.view;

import android.view.View;
import com.baidu.tieba.frs.view.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {
    final /* synthetic */ q bRS;
    private final /* synthetic */ q.b bRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, q.b bVar) {
        this.bRS = qVar;
        this.bRT = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        q.a aVar;
        q.a aVar2;
        aVar = this.bRS.bRO;
        if (aVar != null) {
            aVar2 = this.bRS.bRO;
            aVar2.hT(this.bRT.bRU);
        }
        this.bRS.dismiss();
    }
}
