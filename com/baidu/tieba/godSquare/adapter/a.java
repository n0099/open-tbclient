package com.baidu.tieba.godSquare.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private BdTypeListView gwr;
    private d jPT;
    private GodSquareRecGodAdapter jPU;
    private GodSquareHotGodAdapter jPV;

    public List<com.baidu.adp.widget.ListView.a> bQZ() {
        return this.bjZ;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gwr = bdTypeListView;
        this.jPT = new d(tbPageContext);
        this.jPU = new GodSquareRecGodAdapter(tbPageContext);
        this.jPV = new GodSquareHotGodAdapter(tbPageContext);
        this.bjZ.add(this.jPT);
        this.bjZ.add(this.jPU);
        this.bjZ.add(this.jPV);
    }

    public void notifyDataSetChanged() {
        if (this.gwr != null && (this.gwr.getAdapter() instanceof e)) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }
}
