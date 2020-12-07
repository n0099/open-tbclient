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
    private BdTypeListView gpX;
    private d jHe;
    private c jHf;
    private b jHg;

    public List<com.baidu.adp.widget.ListView.a> bSn() {
        return this.bnf;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gpX = bdTypeListView;
        this.jHe = new d(tbPageContext);
        this.jHf = new c(tbPageContext);
        this.jHg = new b(tbPageContext);
        this.bnf.add(this.jHe);
        this.bnf.add(this.jHf);
        this.bnf.add(this.jHg);
    }

    public void notifyDataSetChanged() {
        if (this.gpX != null && (this.gpX.getAdapter() instanceof f)) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }
}
