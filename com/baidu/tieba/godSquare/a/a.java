package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private BdTypeListView frv;
    private d iqg;
    private c iqh;
    private b iqi;

    public List<com.baidu.adp.widget.ListView.a> bxf() {
        return this.aWf;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.frv = bdTypeListView;
        this.iqg = new d(tbPageContext);
        this.iqh = new c(tbPageContext);
        this.iqi = new b(tbPageContext);
        this.aWf.add(this.iqg);
        this.aWf.add(this.iqh);
        this.aWf.add(this.iqi);
    }

    public void notifyDataSetChanged() {
        if (this.frv != null && (this.frv.getAdapter() instanceof f)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}
