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
    private d iqi;
    private c iqj;
    private b iqk;

    public List<com.baidu.adp.widget.ListView.a> bxf() {
        return this.aWf;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.frv = bdTypeListView;
        this.iqi = new d(tbPageContext);
        this.iqj = new c(tbPageContext);
        this.iqk = new b(tbPageContext);
        this.aWf.add(this.iqi);
        this.aWf.add(this.iqj);
        this.aWf.add(this.iqk);
    }

    public void notifyDataSetChanged() {
        if (this.frv != null && (this.frv.getAdapter() instanceof f)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }
}
