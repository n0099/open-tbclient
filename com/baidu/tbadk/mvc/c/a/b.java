package com.baidu.tbadk.mvc.c.a;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.ah;
import com.baidu.tbadk.core.view.ak;
/* loaded from: classes.dex */
public abstract class b extends e {
    private ak listPullRefreshListener;
    private y scrollToBottomListener;

    public ak setListPullRefreshListener(ah ahVar, com.baidu.tbadk.mvc.c.c cVar) {
        if (ahVar == null || cVar == null) {
            return null;
        }
        com.baidu.tbadk.mvc.c.b dW = cVar.dW(16777217);
        if (ahVar.getView() != null) {
            com.baidu.tbadk.mvc.h.a.a(dW, ahVar.getView());
        }
        createListPullRefreshListener();
        ahVar.a(this.listPullRefreshListener);
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
        com.baidu.tbadk.mvc.h.a.a(cVar.dW(16777218), bdListView);
        if (this.scrollToBottomListener == null) {
            this.scrollToBottomListener = new d(this);
        }
        return this.scrollToBottomListener;
    }
}
