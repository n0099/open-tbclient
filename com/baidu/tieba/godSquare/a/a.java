package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes23.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private BdTypeListView fGf;
    private d iLN;
    private c iLO;
    private b iLP;

    public List<com.baidu.adp.widget.ListView.a> bHv() {
        return this.bdV;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fGf = bdTypeListView;
        this.iLN = new d(tbPageContext);
        this.iLO = new c(tbPageContext);
        this.iLP = new b(tbPageContext);
        this.bdV.add(this.iLN);
        this.bdV.add(this.iLO);
        this.bdV.add(this.iLP);
    }

    public void notifyDataSetChanged() {
        if (this.fGf != null && (this.fGf.getAdapter() instanceof f)) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }
}
