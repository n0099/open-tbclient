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
    protected void kA() {
        yu();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kz() {
        yv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yt() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(yy());
        }
        wH().setListPullRefreshListener(yy(), wJ());
    }

    protected void aW(boolean z) {
        wH().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yu() {
        BdListView listView = getListView();
        yy().a((h) null);
        listView.jC();
        wH().setListPullRefreshListener(yy(), wJ());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yv() {
        getListView().jB();
    }

    protected void yw() {
        yu();
    }

    protected void yx() {
        yv();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        yy().cs(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xm() == 33554437) {
            yw();
            return true;
        } else if (bVar.xm() == 33554438) {
            yx();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak yy() {
        if (this.mPullView == null) {
            this.mPullView = new ak(getPageContext());
        }
        return this.mPullView;
    }
}
