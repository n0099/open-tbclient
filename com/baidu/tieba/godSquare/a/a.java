package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.card.b.a bKa;
    private d bKb;
    private b bKc;
    private List<com.baidu.adp.widget.ListView.a> bcG = new ArrayList();
    private BdTypeListView bcd;

    public List<com.baidu.adp.widget.ListView.a> Yd() {
        return this.bcG;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.bcd = bdTypeListView;
        this.bKa = new com.baidu.tieba.card.b.a(tbPageContext);
        this.bKb = new d(tbPageContext);
        this.bKc = new b(tbPageContext);
        this.bcG.add(this.bKa);
        this.bcG.add(this.bKb);
        this.bcG.add(this.bKc);
    }

    public void notifyDataSetChanged() {
        if (this.bcd != null && (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e)) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }
}
