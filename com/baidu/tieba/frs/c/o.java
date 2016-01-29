package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private cn bfD;
    private SparseArray<a> bnH;
    private ff bnK;
    private FrsActivity bot;
    private Runnable bpT;
    private fe bpU;

    /* loaded from: classes.dex */
    public static class a {
        public int auF;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bnH = new SparseArray<>();
        this.bpU = new p(this);
        this.bnK = new q(this);
        this.bot = frsActivity;
    }

    public void oQ() {
        this.bfD = new cn(this.bot, this.bot.bgj);
        this.bot.a(this.bfD);
    }

    public void onActivityDestroy() {
        if (this.bpT != null) {
            com.baidu.adp.lib.h.h.hr().removeCallbacks(this.bpT);
        }
    }

    public void X(View view) {
        View Qj = this.bfD.Qj();
        if (Qj != null && (Qj instanceof FrameLayout)) {
            ((FrameLayout) Qj).addView(view);
        }
    }

    public fe Sj() {
        return this.bpU;
    }

    public ff Sk() {
        return this.bnK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ac(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean ad(int i, int i2) {
        a aVar = this.bnH.get(ac(i, i2));
        return aVar != null && aVar.auF >= this.bfD.KM().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bnH.put(ac(i, i2), aVar);
    }

    public void gZ(int i) {
        if (this.bfD.KM() != null && this.bfD.KM().getChildAt(0) != null) {
            this.bfD.KM().setSelectionFromTop(this.bfD.KM().getFirstVisiblePosition(), this.bfD.KM().getChildAt(0).getTop() - i);
        }
    }
}
