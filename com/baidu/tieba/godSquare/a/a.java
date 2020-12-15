package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private BdTypeListView gpZ;
    private d jHg;
    private c jHh;
    private b jHi;

    public List<com.baidu.adp.widget.ListView.a> bSo() {
        return this.bnf;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gpZ = bdTypeListView;
        this.jHg = new d(tbPageContext);
        this.jHh = new c(tbPageContext);
        this.jHi = new b(tbPageContext);
        this.bnf.add(this.jHg);
        this.bnf.add(this.jHh);
        this.bnf.add(this.jHi);
    }

    public void notifyDataSetChanged() {
        if (this.gpZ != null && (this.gpZ.getAdapter() instanceof f)) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }
}
