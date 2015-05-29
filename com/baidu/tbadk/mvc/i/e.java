package com.baidu.tbadk.mvc.i;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ak;
import com.baidu.tbadk.core.view.al;
/* loaded from: classes.dex */
public abstract class e extends c {
    private al mPullView;

    public abstract BdListView getListView();

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public e() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oJ() {
        CA();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oI() {
        CB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Cz() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(CE());
        }
        AL().setListPullRefreshListener(CE(), AN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bh(boolean z) {
        AL().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CA() {
        BdListView listView = getListView();
        CE().a((ak) null);
        listView.no();
        AL().setListPullRefreshListener(CE(), AN());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CB() {
        getListView().completePullRefresh();
    }

    protected void CC() {
        CA();
    }

    protected void CD() {
        CB();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        CE().cy(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Br() == 33554437) {
            CC();
            return true;
        } else if (bVar.Br() == 33554438) {
            CD();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public al CE() {
        if (this.mPullView == null) {
            this.mPullView = new al(getPageContext());
        }
        return this.mPullView;
    }
}
