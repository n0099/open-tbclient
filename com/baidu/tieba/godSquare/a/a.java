package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private BdTypeListView duK;
    private com.baidu.tieba.card.divider.a gbt;
    private c gbu;
    private b gbv;

    public List<com.baidu.adp.widget.ListView.a> aJq() {
        return this.agy;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.duK = bdTypeListView;
        this.gbt = new com.baidu.tieba.card.divider.a(tbPageContext);
        this.gbu = new c(tbPageContext);
        this.gbv = new b(tbPageContext);
        this.agy.add(this.gbt);
        this.agy.add(this.gbu);
        this.agy.add(this.gbv);
    }

    public void notifyDataSetChanged() {
        if (this.duK != null && (this.duK.getAdapter() instanceof e)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }
}
