package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
/* loaded from: classes.dex */
public class o extends com.baidu.adp.base.f<FrsActivity> {
    private cs bko;
    private SparseArray<a> bsE;
    private fp bsH;
    private FrsActivity bts;
    private Runnable buU;
    private fo buV;

    /* loaded from: classes.dex */
    public static class a {
        public int avf;
        public int top;
    }

    public o(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.bsE = new SparseArray<>();
        this.buV = new p(this);
        this.bsH = new q(this);
        this.bts = frsActivity;
    }

    public void oJ() {
        this.bko = new cs(this.bts, this.bts.bkV);
        this.bts.a(this.bko);
    }

    public void onActivityDestroy() {
        if (this.buU != null) {
            com.baidu.adp.lib.h.h.hx().removeCallbacks(this.buU);
        }
    }

    public void ab(View view) {
        View Sc = this.bko.Sc();
        if (Sc != null && (Sc instanceof FrameLayout)) {
            ((FrameLayout) Sc).addView(view);
        }
    }

    public fo TY() {
        return this.buV;
    }

    public fp TZ() {
        return this.bsH;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Z(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean aa(int i, int i2) {
        a aVar = this.bsE.get(Z(i, i2));
        return aVar != null && aVar.avf >= this.bko.Mg().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.bsE.put(Z(i, i2), aVar);
    }

    public void hs(int i) {
        if (this.bko.Mg() != null && this.bko.Mg().getChildAt(0) != null) {
            this.bko.Mg().setSelectionFromTop(this.bko.Mg().getFirstVisiblePosition(), this.bko.Mg().getChildAt(0).getTop() - i);
        }
    }
}
