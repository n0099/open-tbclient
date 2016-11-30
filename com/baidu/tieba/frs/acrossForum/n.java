package com.baidu.tieba.frs.acrossForum;

import android.view.View;
import com.baidu.tieba.frs.j.ai;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements ai.a {
    final /* synthetic */ j bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(j jVar) {
        this.bWU = jVar;
    }

    @Override // com.baidu.tieba.frs.j.ai.a
    public void ed(boolean z) {
        View view;
        View view2;
        Runnable runnable;
        View view3;
        this.bWU.bWR = z;
        view = this.bWU.mView;
        if (view != null) {
            if (z) {
                view3 = this.bWU.mView;
                view3.setVisibility(8);
            } else {
                view2 = this.bWU.mView;
                view2.setVisibility(0);
            }
            com.baidu.adp.lib.h.h eG = com.baidu.adp.lib.h.h.eG();
            runnable = this.bWU.bWT;
            eG.post(runnable);
        }
    }
}
