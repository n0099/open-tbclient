package com.baidu.tieba.frs.game.strategy.view;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    private b dxD;
    private final List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;
    private com.baidu.adp.base.e mPageContext;

    public c(com.baidu.adp.base.e eVar, BdTypeListView bdTypeListView) {
        this.mPageContext = eVar;
        this.mListView = bdTypeListView;
        initAdapters();
    }

    private void initAdapters() {
        this.dxD = new b((TbPageContext) this.mPageContext, com.baidu.tieba.frs.game.strategy.data.b.dwL);
        this.mAdapters.add(this.dxD);
        this.mListView.addAdapters(this.mAdapters);
    }

    public void setData(List<h> list) {
        if (this.mListView != null) {
            this.mListView.setData(list);
        }
    }

    public void b(n nVar) {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar != null) {
                aVar.setOnAdapterItemClickListener(nVar);
            }
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
