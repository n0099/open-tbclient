package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ab;
/* loaded from: classes.dex */
public abstract class b extends e {
    private com.baidu.adp.widget.ListView.g listPullRefreshListener;
    private ab scrollToBottomListener;

    public com.baidu.adp.widget.ListView.g setListPullRefreshListener(com.baidu.adp.widget.ListView.d dVar, com.baidu.tbadk.mvc.c.c cVar) {
        if (dVar == null || cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.c.b dj = cVar.dj(16777217);
        if (dVar.getView() != null) {
            com.baidu.tbadk.mvc.g.a.a(dj, dVar.getView());
        }
        createListPullRefreshListener();
        dVar.a(this.listPullRefreshListener);
        return this.listPullRefreshListener;
    }

    private void createListPullRefreshListener() {
        if (this.listPullRefreshListener == null) {
            this.listPullRefreshListener = new c(this);
        }
    }

    public ab setScrollToBottomListener(BdListView bdListView, com.baidu.tbadk.mvc.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.g.a.a(cVar.dj(16777218), bdListView);
        if (this.scrollToBottomListener == null) {
            this.scrollToBottomListener = new d(this);
        }
        return this.scrollToBottomListener;
    }
}
