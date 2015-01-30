package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.ac;
/* loaded from: classes.dex */
public abstract class b extends e {
    private com.baidu.adp.widget.ListView.h listPullRefreshListener;
    private ac scrollToBottomListener;

    public com.baidu.adp.widget.ListView.h setListPullRefreshListener(com.baidu.adp.widget.ListView.e eVar, com.baidu.tbadk.mvc.c.c cVar) {
        if (eVar == null || cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.c.b dJ = cVar.dJ(16777217);
        if (eVar.getView() != null) {
            com.baidu.tbadk.mvc.h.a.a(dJ, eVar.getView());
        }
        createListPullRefreshListener();
        eVar.a(this.listPullRefreshListener);
        return this.listPullRefreshListener;
    }

    private void createListPullRefreshListener() {
        if (this.listPullRefreshListener == null) {
            this.listPullRefreshListener = new c(this);
        }
    }

    public ac setScrollToBottomListener(BdListView bdListView, com.baidu.tbadk.mvc.c.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.h.a.a(cVar.dJ(16777218), bdListView);
        if (this.scrollToBottomListener == null) {
            this.scrollToBottomListener = new d(this);
        }
        return this.scrollToBottomListener;
    }
}
