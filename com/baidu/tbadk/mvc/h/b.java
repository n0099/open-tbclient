package com.baidu.tbadk.mvc.h;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class b extends a {
    private y Yg;

    public abstract BdListView uf();

    public b(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ud() {
        uh();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ue() {
        ui();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ug() {
        BdListView uf = uf();
        if (uf != null) {
            uf.setPullRefresh(ul());
        }
        ta().setListPullRefreshListener(ul(), tb());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aG(boolean z) {
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uh() {
        BdListView uf = uf();
        ul().a((g) null);
        uf.hO();
        ta().setListPullRefreshListener(ul(), tb());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ui() {
        uf().hN();
    }

    protected void uj() {
        uh();
    }

    protected void uk() {
        ui();
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        ul().bM(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.h.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tr() == 33554437) {
            uj();
            return true;
        } else if (bVar.tr() == 33554438) {
            uk();
            return true;
        } else {
            return false;
        }
    }

    protected y ul() {
        if (this.Yg == null) {
            this.Yg = new y(this.Xj);
        }
        return this.Yg;
    }
}
