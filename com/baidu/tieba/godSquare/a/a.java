package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private BdTypeListView gcr;
    private d jna;
    private c jnb;
    private b jnc;

    public List<com.baidu.adp.widget.ListView.a> bMJ() {
        return this.bje;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gcr = bdTypeListView;
        this.jna = new d(tbPageContext);
        this.jnb = new c(tbPageContext);
        this.jnc = new b(tbPageContext);
        this.bje.add(this.jna);
        this.bje.add(this.jnb);
        this.bje.add(this.jnc);
    }

    public void notifyDataSetChanged() {
        if (this.gcr != null && (this.gcr.getAdapter() instanceof f)) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }
}
