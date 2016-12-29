package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tieba.frs.h.an;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements an.a {
    final /* synthetic */ j bDe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bDe = jVar;
    }

    @Override // com.baidu.tieba.frs.h.an.a
    public void dN(boolean z) {
        View view;
        View view2;
        Runnable runnable;
        View view3;
        this.bDe.bDb = z;
        view = this.bDe.mView;
        if (view != null) {
            if (z) {
                view3 = this.bDe.mView;
                view3.setVisibility(8);
            } else {
                view2 = this.bDe.mView;
                view2.setVisibility(0);
            }
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.bDe.bDd;
            eG.post(runnable);
        }
    }
}
