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
    private BdTypeListView faQ;
    private d hUV;
    private c hUW;
    private b hUX;

    public List<com.baidu.adp.widget.ListView.a> bqW() {
        return this.aSj;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.faQ = bdTypeListView;
        this.hUV = new d(tbPageContext);
        this.hUW = new c(tbPageContext);
        this.hUX = new b(tbPageContext);
        this.aSj.add(this.hUV);
        this.aSj.add(this.hUW);
        this.aSj.add(this.hUX);
    }

    public void notifyDataSetChanged() {
        if (this.faQ != null && (this.faQ.getAdapter() instanceof e)) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }
}
