package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private BdTypeListView ekb;
    private d gUT;
    private c gUU;
    private b gUV;

    public List<com.baidu.adp.widget.ListView.a> bcE() {
        return this.asE;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ekb = bdTypeListView;
        this.gUT = new d(tbPageContext);
        this.gUU = new c(tbPageContext);
        this.gUV = new b(tbPageContext);
        this.asE.add(this.gUT);
        this.asE.add(this.gUU);
        this.asE.add(this.gUV);
    }

    public void notifyDataSetChanged() {
        if (this.ekb != null && (this.ekb.getAdapter() instanceof e)) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }
}
