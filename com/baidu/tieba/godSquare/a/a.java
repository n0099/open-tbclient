package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeListView eka;
    private d gUR;
    private c gUS;
    private b gUT;

    public List<com.baidu.adp.widget.ListView.a> bcC() {
        return this.asE;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eka = bdTypeListView;
        this.gUR = new d(tbPageContext);
        this.gUS = new c(tbPageContext);
        this.gUT = new b(tbPageContext);
        this.asE.add(this.gUR);
        this.asE.add(this.gUS);
        this.asE.add(this.gUT);
    }

    public void notifyDataSetChanged() {
        if (this.eka != null && (this.eka.getAdapter() instanceof e)) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }
}
