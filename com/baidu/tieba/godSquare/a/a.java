package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private BdTypeListView efM;
    private d gPx;
    private c gPy;
    private b gPz;

    public List<com.baidu.adp.widget.ListView.a> aZO() {
        return this.aoz;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efM = bdTypeListView;
        this.gPx = new d(tbPageContext);
        this.gPy = new c(tbPageContext);
        this.gPz = new b(tbPageContext);
        this.aoz.add(this.gPx);
        this.aoz.add(this.gPy);
        this.aoz.add(this.gPz);
    }

    public void notifyDataSetChanged() {
        if (this.efM != null && (this.efM.getAdapter() instanceof e)) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }
}
