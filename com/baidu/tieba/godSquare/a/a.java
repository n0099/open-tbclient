package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tieba.card.divider.a gaV;
    private c gaW;
    private b gaX;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();
    private BdTypeListView mListView;

    public List<com.baidu.adp.widget.ListView.a> aJo() {
        return this.mAdapters;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.mListView = bdTypeListView;
        this.gaV = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.gaW = new c(tbPageContext);
        this.gaX = new b(tbPageContext);
        this.mAdapters.add(this.gaV);
        this.mAdapters.add(this.gaW);
        this.mAdapters.add(this.gaX);
    }

    public void notifyDataSetChanged() {
        if (this.mListView != null && (this.mListView.getAdapter() instanceof e)) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }
}
