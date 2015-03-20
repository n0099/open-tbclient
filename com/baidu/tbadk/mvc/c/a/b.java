package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.ac;
import com.baidu.tbadk.core.view.af;
/* loaded from: classes.dex */
public abstract class b extends e {
    private af listPullRefreshListener;
    private y scrollToBottomListener;

    public af setListPullRefreshListener(ac acVar, com.baidu.tbadk.mvc.c.c cVar) {
        if (acVar == null || cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.c.b dM = cVar.dM(16777217);
        if (acVar.getView() != null) {
            com.baidu.tbadk.mvc.h.a.a(dM, acVar.getView());
        }
        createListPullRefreshListener();
        acVar.a(this.listPullRefreshListener);
        return this.listPullRefreshListener;
    }

    private void createListPullRefreshListener() {
        if (this.listPullRefreshListener == null) {
            this.listPullRefreshListener = new c(this);
        }
    }

    public y setScrollToBottomListener(BdListView bdListView, com.baidu.tbadk.mvc.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.h.a.a(cVar.dM(16777218), bdListView);
        if (this.scrollToBottomListener == null) {
            this.scrollToBottomListener = new d(this);
        }
        return this.scrollToBottomListener;
    }
}
