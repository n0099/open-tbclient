package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private bs aTU;
    private FrsActivity baR;
    private SparseArray<a> bah;
    private eb bak;
    private Runnable bcd;
    private ea bce;

    /* loaded from: classes.dex */
    public static class a {
        public int bch;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bah = new SparseArray<>();
        this.bce = new p(this);
        this.bak = new q(this);
        this.baR = frsActivity;
    }

    public void oQ() {
        this.aTU = new bs(this.baR, this.baR.aUx);
        this.baR.a(this.aTU);
    }

    public void onActivityDestroy() {
        if (this.bcd != null) {
            com.baidu.adp.lib.g.h.hg().removeCallbacks(this.bcd);
        }
    }

    public void D(View view) {
        View Ma = this.aTU.Ma();
        if (Ma != null && (Ma instanceof FrameLayout)) {
            ((FrameLayout) Ma).addView(view);
        }
    }

    public ea NP() {
        return this.bce;
    }

    public eb NQ() {
        return this.bak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean Z(int i, int i2) {
        a aVar = this.bah.get(Y(i, i2));
        return aVar != null && aVar.bch >= this.aTU.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bah.put(Y(i, i2), aVar);
    }
}
