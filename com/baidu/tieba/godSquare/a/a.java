package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private BdTypeListView fml;
    private d ikd;
    private c ike;
    private b ikf;

    public List<com.baidu.adp.widget.ListView.a> btV() {
        return this.aUP;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fml = bdTypeListView;
        this.ikd = new d(tbPageContext);
        this.ike = new c(tbPageContext);
        this.ikf = new b(tbPageContext);
        this.aUP.add(this.ikd);
        this.aUP.add(this.ike);
        this.aUP.add(this.ikf);
    }

    public void notifyDataSetChanged() {
        if (this.fml != null && (this.fml.getAdapter() instanceof f)) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }
}
