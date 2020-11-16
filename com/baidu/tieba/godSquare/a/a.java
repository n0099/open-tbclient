package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private BdTypeListView ghN;
    private d jtE;
    private c jtF;
    private b jtG;

    public List<com.baidu.adp.widget.ListView.a> bOC() {
        return this.biN;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ghN = bdTypeListView;
        this.jtE = new d(tbPageContext);
        this.jtF = new c(tbPageContext);
        this.jtG = new b(tbPageContext);
        this.biN.add(this.jtE);
        this.biN.add(this.jtF);
        this.biN.add(this.jtG);
    }

    public void notifyDataSetChanged() {
        if (this.ghN != null && (this.ghN.getAdapter() instanceof f)) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }
}
