package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.card.divider.a dLa;
    private c dLb;
    private b dLc;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> asu() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.dLa = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.dLb = new c(tbPageContext);
        this.dLc = new b(tbPageContext);
        this.mAdapters.add(this.dLa);
        this.mAdapters.add(this.dLb);
        this.mAdapters.add(this.dLc);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
