package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes11.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private BdTypeListView fbb;
    private d hVI;
    private c hVJ;
    private b hVK;

    public List<com.baidu.adp.widget.ListView.a> bqY() {
        return this.aSj;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fbb = bdTypeListView;
        this.hVI = new d(tbPageContext);
        this.hVJ = new c(tbPageContext);
        this.hVK = new b(tbPageContext);
        this.aSj.add(this.hVI);
        this.aSj.add(this.hVJ);
        this.aSj.add(this.hVK);
    }

    public void notifyDataSetChanged() {
        if (this.fbb != null && (this.fbb.getAdapter() instanceof e)) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }
}
