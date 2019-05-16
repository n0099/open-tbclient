package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.card.divider.a fVf;
    private c fVg;
    private b fVh;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> aHM() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.fVf = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.fVg = new c(tbPageContext);
        this.fVh = new b(tbPageContext);
        this.mAdapters.add(this.fVf);
        this.mAdapters.add(this.fVg);
        this.mAdapters.add(this.fVh);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
