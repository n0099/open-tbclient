package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.db;
import com.baidu.tieba.frs.dc;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.base.f<FrsActivity> {
    private bl aUw;
    private SparseArray<a> aZL;
    private dc aZO;
    private FrsActivity bat;
    private Runnable bbE;
    private db bbF;

    /* loaded from: classes.dex */
    public static class a {
        public int bbI;
        public int top;
    }

    public n(FrsActivity frsActivity) {
        super(frsActivity.getPageContext());
        this.aZL = new SparseArray<>();
        this.bbF = new o(this);
        this.aZO = new p(this);
        this.bat = frsActivity;
    }

    public void oS() {
        this.aUw = new bl(this.bat, this.bat.aUY);
        this.bat.a(this.aUw);
    }

    public void onActivityDestroy() {
        if (this.bbE != null) {
            com.baidu.adp.lib.g.h.hi().removeCallbacks(this.bbE);
        }
    }

    public void D(View view) {
        View Mk = this.aUw.Mk();
        if (Mk != null && (Mk instanceof FrameLayout)) {
            ((FrameLayout) Mk).addView(view);
        }
    }

    public db NO() {
        return this.bbF;
    }

    public dc NP() {
        return this.aZO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Y(int i, int i2) {
        return (i * 100) + i2;
    }

    public boolean Z(int i, int i2) {
        a aVar = this.aZL.get(Y(i, i2));
        return aVar != null && aVar.bbI >= this.aUw.getListView().getHeaderViewsCount() + (-1);
    }

    public void a(int i, int i2, a aVar) {
        this.aZL.put(Y(i, i2), aVar);
    }
}
