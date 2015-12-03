package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.et;
import com.baidu.tieba.frs.eu;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private cd aZq;
    private SparseArray<a> bgT;
    private eu bgW;
    private FrsActivity bhN;
    private Runnable bjn;
    private et bjo;

    /* loaded from: classes.dex */
    public static class a {
        public int asj;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bgT = new SparseArray<>();
        this.bjo = new p(this);
        this.bgW = new q(this);
        this.bhN = frsActivity;
    }

    public void oX() {
        this.aZq = new cd(this.bhN, this.bhN.aZT);
        this.bhN.a(this.aZq);
    }

    public void onActivityDestroy() {
        if (this.bjn != null) {
            com.baidu.adp.lib.h.h.hj().removeCallbacks(this.bjn);
        }
    }

    public void I(View view) {
        View NN = this.aZq.NN();
        if (NN != null && (NN instanceof FrameLayout)) {
            ((FrameLayout) NN).addView(view);
        }
    }

    public et PN() {
        return this.bjo;
    }

    public eu PO() {
        return this.bgW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ac(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean ad(int i, int i2) {
        a aVar = this.bgT.get(ac(i, i2));
        return aVar != null && aVar.asj >= this.aZq.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bgT.put(ac(i, i2), aVar);
    }

    public void gJ(int i) {
        if (this.aZq.getListView() != null && this.aZq.getListView().getChildAt(0) != null) {
            this.aZq.getListView().setSelectionFromTop(this.aZq.getListView().getFirstVisiblePosition(), this.aZq.getListView().getChildAt(0).getTop() - i);
        }
    }
}
