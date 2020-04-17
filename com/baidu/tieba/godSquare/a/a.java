package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private BdTypeListView eOe;
    private d hGd;
    private c hGe;
    private b hGf;

    public List<com.baidu.adp.widget.ListView.a> blA() {
        return this.aMd;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eOe = bdTypeListView;
        this.hGd = new d(tbPageContext);
        this.hGe = new c(tbPageContext);
        this.hGf = new b(tbPageContext);
        this.aMd.add(this.hGd);
        this.aMd.add(this.hGe);
        this.aMd.add(this.hGf);
    }

    public void notifyDataSetChanged() {
        if (this.eOe != null && (this.eOe.getAdapter() instanceof e)) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }
}
