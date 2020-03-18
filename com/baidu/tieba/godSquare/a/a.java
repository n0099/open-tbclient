package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private BdTypeListView ekE;
    private d gWm;
    private c gWn;
    private b gWo;

    public List<com.baidu.adp.widget.ListView.a> bcJ() {
        return this.asP;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ekE = bdTypeListView;
        this.gWm = new d(tbPageContext);
        this.gWn = new c(tbPageContext);
        this.gWo = new b(tbPageContext);
        this.asP.add(this.gWm);
        this.asP.add(this.gWn);
        this.asP.add(this.gWo);
    }

    public void notifyDataSetChanged() {
        if (this.ekE != null && (this.ekE.getAdapter() instanceof e)) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }
}
