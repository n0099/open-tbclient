package com.baidu.tieba.frs.h;

import android.view.View;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.fi;
/* loaded from: classes.dex */
public class aa extends com.baidu.adp.base.f<FrsActivity> {
    private cn bgo;
    private FrsActivity bpj;
    private fi brn;
    private Runnable buG;

    /* loaded from: classes.dex */
    public static class a {
        public int are;
        public int top;
    }

    public aa(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.brn = new ab(this);
        this.bpj = frsActivity;
    }

    public void b(com.baidu.tieba.frs.entelechy.b.a aVar) {
        this.bgo = new cn(this.bpj, this.bpj.bha, aVar);
        this.bpj.a(this.bgo);
    }

    public void onActivityDestroy() {
        if (this.buG != null) {
            com.baidu.adp.lib.h.h.dL().removeCallbacks(this.buG);
        }
    }

    public fi Uc() {
        return this.brn;
    }

    public View getRootView() {
        return this.bgo.Rb();
    }

    public void gU(int i) {
        if (this.bgo.QR() != null && this.bgo.QR().getChildAt(0) != null) {
            this.bgo.QR().setSelectionFromTop(this.bgo.QR().getFirstVisiblePosition(), this.bgo.QR().getChildAt(0).getTop() - i);
        }
    }
}
