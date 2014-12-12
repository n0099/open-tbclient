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
        yk();
    }

    @Override // com.baidu.tbadk.mvc.i.a
    protected void kG() {
        yl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yj() {
        BdListView listView = getListView();
        if (listView != null) {
            listView.setPullRefresh(yo());
        }
        wx().setListPullRefreshListener(yo(), wz());
    }

    protected void aU(boolean z) {
        wx().addEventDelegate(this);
        g(16777217, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yk() {
        BdListView listView = getListView();
        yo().a((h) null);
        listView.jK();
        wx().setListPullRefreshListener(yo(), wz());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void yl() {
        getListView().jJ();
    }

    protected void ym() {
        yk();
    }

    protected void yn() {
        yl();
    }

    @Override // com.baidu.tbadk.mvc.core.d, com.baidu.tbadk.mvc.core.c, com.baidu.tieba.tbadkCore.y
    public boolean a(TbPageContext<?> tbPageContext, int i) {
        super.a(tbPageContext, i);
        yo().cl(i);
        return true;
    }

    @Override // com.baidu.tbadk.mvc.i.a, com.baidu.tbadk.mvc.core.c, com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (super.a(bVar)) {
            return true;
        }
        if (bVar.xc() == 33554437) {
            ym();
            return true;
        } else if (bVar.xc() == 33554438) {
            yn();
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ak yo() {
        if (this.mPullView == null) {
            this.mPullView = new ak(getContext());
        }
        return this.mPullView;
    }
}
