package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private BdTypeListView eko;
    private d gVf;
    private c gVg;
    private b gVh;

    public List<com.baidu.adp.widget.ListView.a> bcF() {
        return this.asF;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eko = bdTypeListView;
        this.gVf = new d(tbPageContext);
        this.gVg = new c(tbPageContext);
        this.gVh = new b(tbPageContext);
        this.asF.add(this.gVf);
        this.asF.add(this.gVg);
        this.asF.add(this.gVh);
    }

    public void notifyDataSetChanged() {
        if (this.eko != null && (this.eko.getAdapter() instanceof e)) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }
}
