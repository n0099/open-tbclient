package com.baidu.tieba.godSquare.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private BdTypeListView gzb;
    private d jXv;
    private GodSquareRecGodAdapter jXw;
    private GodSquareHotGodAdapter jXx;

    public List<com.baidu.adp.widget.ListView.a> bRD() {
        return this.bns;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gzb = bdTypeListView;
        this.jXv = new d(tbPageContext);
        this.jXw = new GodSquareRecGodAdapter(tbPageContext);
        this.jXx = new GodSquareHotGodAdapter(tbPageContext);
        this.bns.add(this.jXv);
        this.bns.add(this.jXw);
        this.bns.add(this.jXx);
    }

    public void notifyDataSetChanged() {
        if (this.gzb != null && (this.gzb.getAdapter() instanceof e)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }
}
