package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.card.b.a bKg;
    private d bKh;
    private b bKi;
    private List<com.baidu.adp.widget.ListView.a> bei = new ArrayList();
    private BdTypeListView bej;

    public List<com.baidu.adp.widget.ListView.a> Pb() {
        return this.bei;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.bej = bdTypeListView;
        this.bKg = new com.baidu.tieba.card.b.a(tbPageContext);
        this.bKh = new d(tbPageContext);
        this.bKi = new b(tbPageContext);
        this.bei.add(this.bKg);
        this.bei.add(this.bKh);
        this.bei.add(this.bKi);
    }

    public void notifyDataSetChanged() {
        if (this.bej != null && (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetChanged();
        }
    }
}
