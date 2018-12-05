package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private c eoA;
    private b eoB;
    private com.baidu.tieba.card.divider.a eoz;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> azA() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.eoz = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.eoA = new c(tbPageContext);
        this.eoB = new b(tbPageContext);
        this.mAdapters.add(this.eoz);
        this.mAdapters.add(this.eoA);
        this.mAdapters.add(this.eoB);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
