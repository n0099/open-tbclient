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
        BO();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void os() {
        BP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BN() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(BS());
        }
        zZ().setListPullRefreshListener(BS(), Ab());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ba(boolean z) {
        zZ().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BO() {
        BdListView listView = getListView();
        BS().a((af) null);
        listView.mX();
        zZ().setListPullRefreshListener(BS(), Ab());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void BP() {
        getListView().mW();
    }

    protected void BQ() {
        BO();
    }

    protected void BR() {
        BP();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.ab
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        BS().ct(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.AF() == 33554437) {
            BQ();
            return true;
        } else if (bVar.AF() == 33554438) {
            BR();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ag BS() {
        if (this.mPullView == null) {
            this.mPullView = new ag(getPageContext());
        }
        return this.mPullView;
    }
}
