package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMj = new ArrayList();
    private BdTypeListView eOj;
    private d hGj;
    private c hGk;
    private b hGl;

    public List<com.baidu.adp.widget.ListView.a> bly() {
        return this.aMj;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eOj = bdTypeListView;
        this.hGj = new d(tbPageContext);
        this.hGk = new c(tbPageContext);
        this.hGl = new b(tbPageContext);
        this.aMj.add(this.hGj);
        this.aMj.add(this.hGk);
        this.aMj.add(this.hGl);
    }

    public void notifyDataSetChanged() {
        if (this.eOj != null && (this.eOj.getAdapter() instanceof e)) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }
}
