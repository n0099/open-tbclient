package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.card.divider.a gaf;
    private c gag;
    private b gah;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> aJm() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.gaf = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.gag = new c(tbPageContext);
        this.gah = new b(tbPageContext);
        this.mAdapters.add(this.gaf);
        this.mAdapters.add(this.gag);
        this.mAdapters.add(this.gah);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
