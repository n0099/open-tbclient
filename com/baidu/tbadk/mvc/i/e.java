package com.baidu.tbadk.mvc.i;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.af;
import com.baidu.tbadk.core.view.ag;
/* loaded from: classes.dex */
public abstract class e extends c {
    private ag mPullView;

    public abstract BdListView getListView();

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    public e() {
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void ot() {
        BI();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void os() {
        BJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BH() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(BM());
        }
        zT().setListPullRefreshListener(BM(), zV());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ba(boolean z) {
        zT().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BI() {
        BdListView listView = getListView();
        BM().a((af) null);
        listView.mX();
        zT().setListPullRefreshListener(BM(), zV());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BJ() {
        getListView().mW();
    }

    protected void BK() {
        BI();
    }

    protected void BL() {
        BJ();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        BM().ct(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.Az() == 33554437) {
            BK();
            return true;
        } else if (bVar.Az() == 33554438) {
            BL();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ag BM() {
        if (this.mPullView == null) {
            this.mPullView = new ag(getPageContext());
        }
        return this.mPullView;
    }
}
