package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ed;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private bs aUc;
    private SparseArray<a> baB;
    private ed baE;
    private FrsActivity bbk;
    private Runnable bcI;
    private ec bcJ;

    /* loaded from: classes.dex */
    public static class a {
        public int bcM;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.baB = new SparseArray<>();
        this.bcJ = new p(this);
        this.baE = new q(this);
        this.bbk = frsActivity;
    }

    public void oR() {
        this.aUc = new bs(this.bbk, this.bbk.aUF);
        this.bbk.a(this.aUc);
    }

    public void onActivityDestroy() {
        if (this.bcI != null) {
            com.baidu.adp.lib.g.h.hh().removeCallbacks(this.bcI);
        }
    }

    public void E(View view) {
        View Mm = this.aUc.Mm();
        if (Mm != null && (Mm instanceof FrameLayout)) {
            ((FrameLayout) Mm).addView(view);
        }
    }

    public ec Oh() {
        return this.bcJ;
    }

    public ed Oi() {
        return this.baE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int aa(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean ab(int i, int i2) {
        a aVar = this.baB.get(aa(i, i2));
        return aVar != null && aVar.bcM >= this.aUc.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.baB.put(aa(i, i2), aVar);
    }

    public void gn(int i) {
        if (this.aUc.getListView() != null && this.aUc.getListView().getChildAt(0) != null) {
            this.aUc.getListView().setSelectionFromTop(this.aUc.getListView().getFirstVisiblePosition(), this.aUc.getListView().getChildAt(0).getTop() - i);
        }
    }
}
