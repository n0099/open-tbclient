package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ev;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private cg bdm;
    private SparseArray<a> bkK;
    private ev bkN;
    private FrsActivity blE;
    private Runnable bne;
    private eu bnf;

    /* loaded from: classes.dex */
    public static class a {
        public int atN;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bkK = new SparseArray<>();
        this.bnf = new p(this);
        this.bkN = new q(this);
        this.blE = frsActivity;
    }

    public void ov() {
        this.bdm = new cg(this.blE, this.blE.bdQ);
        this.blE.a(this.bdm);
    }

    public void onActivityDestroy() {
        if (this.bne != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.bne);
        }
    }

    public void J(View view) {
        View Og = this.bdm.Og();
        if (Og != null && (Og instanceof FrameLayout)) {
            ((FrameLayout) Og).addView(view);
        }
    }

    public eu Qf() {
        return this.bnf;
    }

    public ev Qg() {
        return this.bkN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ac(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean ad(int i, int i2) {
        a aVar = this.bkK.get(ac(i, i2));
        return aVar != null && aVar.atN >= this.bdm.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bkK.put(ac(i, i2), aVar);
    }

    public void gC(int i) {
        if (this.bdm.getListView() != null && this.bdm.getListView().getChildAt(0) != null) {
            this.bdm.getListView().setSelectionFromTop(this.bdm.getListView().getFirstVisiblePosition(), this.bdm.getListView().getChildAt(0).getTop() - i);
        }
    }
}
