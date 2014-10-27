package com.baidu.tbadk.mvc.h;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.g;
import com.baidu.tbadk.core.view.y;
import com.baidu.tbadk.mvc.core.MvcActivity;
/* loaded from: classes.dex */
public abstract class b extends a {
    private y Yc;

    public abstract BdListView ud();

    public b(MvcActivity<?, ?> mvcActivity) {
        super(mvcActivity);
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void ub() {
        uf();
    }

    @Override // com.baidu.tbadk.mvc.h.a
    protected void uc() {
        ug();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ue() {
        BdListView ud = ud();
        if (ud != null) {
            ud.setPullRefresh(uj());
        }
        sY().setListPullRefreshListener(uj(), sZ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aG(boolean z) {
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void uf() {
        BdListView ud = ud();
        uj().a((g) null);
        ud.hO();
        sY().setListPullRefreshListener(uj(), sZ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ug() {
        ud().hN();
    }

    protected void uh() {
        uf();
    }

    protected void ui() {
        ug();
    }

    @Override // com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.e.a
    public boolean dg(int i) {
        super.dg(i);
        uj().bM(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.h.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.tp() == 33554437) {
            uh();
            return true;
        } else if (bVar.tp() == 33554438) {
            ui();
            return true;
        } else {
            return false;
        }
    }

    protected y uj() {
        if (this.Yc == null) {
            this.Yc = new y(this.Xf);
        }
        return this.Yc;
    }
}
