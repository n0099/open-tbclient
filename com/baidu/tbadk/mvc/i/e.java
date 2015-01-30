package com.baidu.tbadk.mvc.i;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.ak;
/* loaded from: classes.dex */
public abstract class e extends c {
    private ak mPullView;

    public abstract BdListView getListView();

    public e(com.baidu.tbadk.mvc.core.e<?, ?, ?> eVar) {
        super(eVar);
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kH() {
        yA();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kG() {
        yB();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yz() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(yE());
        }
        wN().setListPullRefreshListener(yE(), wP());
    }

    protected void aW(boolean z) {
        wN().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yA() {
        BdListView listView = getListView();
        yE().a((h) null);
        listView.jJ();
        wN().setListPullRefreshListener(yE(), wP());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yB() {
        getListView().jI();
    }

    protected void yC() {
        yA();
    }

    protected void yD() {
        yB();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        yE().cs(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xs() == 33554437) {
            yC();
            return true;
        } else if (bVar.xs() == 33554438) {
            yD();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak yE() {
        if (this.mPullView == null) {
            this.mPullView = new ak(getPageContext());
        }
        return this.mPullView;
    }
}
