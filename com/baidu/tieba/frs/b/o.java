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
    private bs aTJ;
    private SparseArray<a> aZW;
    private eb aZZ;
    private FrsActivity baG;
    private Runnable bbS;
    private ea bbT;

    /* loaded from: classes.dex */
    public static class a {
        public int bbW;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aZW = new SparseArray<>();
        this.bbT = new p(this);
        this.aZZ = new q(this);
        this.baG = frsActivity;
    }

    public void oQ() {
        this.aTJ = new bs(this.baG, this.baG.aUm);
        this.baG.a(this.aTJ);
    }

    public void onActivityDestroy() {
        if (this.bbS != null) {
            com.baidu.adp.lib.g.h.hg().removeCallbacks(this.bbS);
        }
    }

    public void D(View view) {
        View Ma = this.aTJ.Ma();
        if (Ma != null && (Ma instanceof FrameLayout)) {
            ((FrameLayout) Ma).addView(view);
        }
    }

    public ea NP() {
        return this.bbT;
    }

    public eb NQ() {
        return this.aZZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean Z(int i, int i2) {
        a aVar = this.aZW.get(Y(i, i2));
        return aVar != null && aVar.bbW >= this.aTJ.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.aZW.put(Y(i, i2), aVar);
    }
}
