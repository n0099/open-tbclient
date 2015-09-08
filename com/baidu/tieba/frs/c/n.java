package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.di;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<FrsActivity> {
    private bi aUL;
    private FrsActivity baN;
    private SparseArray<a> bad;
    private di bag;
    private Runnable bbY;
    private dh bbZ;

    /* loaded from: classes.dex */
    public static class a {
        public int bcc;
        public int top;
    }

    public n(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bad = new SparseArray<>();
        this.bbZ = new o(this);
        this.bag = new p(this);
        this.baN = frsActivity;
    }

    public void oP() {
        this.aUL = new bi(this.baN, this.baN.aVm);
        this.baN.a(this.aUL);
    }

    public void onActivityDestroy() {
        if (this.bbY != null) {
            com.baidu.adp.lib.g.h.hf().removeCallbacks(this.bbY);
        }
    }

    public void D(View view) {
        View Mb = this.aUL.Mb();
        if (Mb != null && (Mb instanceof FrameLayout)) {
            ((FrameLayout) Mb).addView(view);
        }
    }

    public dh NP() {
        return this.bbZ;
    }

    public di NQ() {
        return this.bag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean Z(int i, int i2) {
        a aVar = this.bad.get(Y(i, i2));
        return aVar != null && aVar.bcc >= this.aUL.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bad.put(Y(i, i2), aVar);
    }
}
