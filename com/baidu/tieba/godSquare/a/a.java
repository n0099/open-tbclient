package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private BdTypeListView fCP;
    private d iEm;
    private c iEn;
    private b iEo;

    public List<com.baidu.adp.widget.ListView.a> bGe() {
        return this.bbu;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fCP = bdTypeListView;
        this.iEm = new d(tbPageContext);
        this.iEn = new c(tbPageContext);
        this.iEo = new b(tbPageContext);
        this.bbu.add(this.iEm);
        this.bbu.add(this.iEn);
        this.bbu.add(this.iEo);
    }

    public void notifyDataSetChanged() {
        if (this.fCP != null && (this.fCP.getAdapter() instanceof f)) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }
}
