package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tieba.card.divider.a dQZ;
    private c dRa;
    private b dRb;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> ati() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.dQZ = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.dRa = new c(tbPageContext);
        this.dRb = new b(tbPageContext);
        this.mAdapters.add(this.dQZ);
        this.mAdapters.add(this.dRa);
        this.mAdapters.add(this.dRb);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
