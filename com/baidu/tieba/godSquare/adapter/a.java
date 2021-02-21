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
    private BdTypeListView gzp;
    private d jXJ;
    private GodSquareRecGodAdapter jXK;
    private GodSquareHotGodAdapter jXL;

    public List<com.baidu.adp.widget.ListView.a> bRK() {
        return this.bns;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gzp = bdTypeListView;
        this.jXJ = new d(tbPageContext);
        this.jXK = new GodSquareRecGodAdapter(tbPageContext);
        this.jXL = new GodSquareHotGodAdapter(tbPageContext);
        this.bns.add(this.jXJ);
        this.bns.add(this.jXK);
        this.bns.add(this.jXL);
    }

    public void notifyDataSetChanged() {
        if (this.gzp != null && (this.gzp.getAdapter() instanceof e)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }
}
