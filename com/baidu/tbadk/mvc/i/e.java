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
        CB();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void oI() {
        CC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CA() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(CF());
        }
        AM().setListPullRefreshListener(CF(), AO());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bh(boolean z) {
        AM().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CB() {
        BdListView listView = getListView();
        CF().a((ak) null);
        listView.no();
        AM().setListPullRefreshListener(CF(), AO());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void CC() {
        getListView().completePullRefresh();
    }

    protected void CD() {
        CB();
    }

    protected void CE() {
        CC();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        CF().cy(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Bs() == 33554437) {
            CD();
            return true;
        } else if (bVar.Bs() == 33554438) {
            CE();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public al CF() {
        if (this.mPullView == null) {
            this.mPullView = new al(getPageContext());
        }
        return this.mPullView;
    }
}
