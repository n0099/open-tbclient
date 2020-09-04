package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes18.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private BdTypeListView fCT;
    private d iEs;
    private c iEt;
    private b iEu;

    public List<com.baidu.adp.widget.ListView.a> bGf() {
        return this.bbw;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fCT = bdTypeListView;
        this.iEs = new d(tbPageContext);
        this.iEt = new c(tbPageContext);
        this.iEu = new b(tbPageContext);
        this.bbw.add(this.iEs);
        this.bbw.add(this.iEt);
        this.bbw.add(this.iEu);
    }

    public void notifyDataSetChanged() {
        if (this.fCT != null && (this.fCT.getAdapter() instanceof f)) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }
}
