package com.baidu.tieba.godSquare.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boM = new ArrayList();
    private BdTypeListView gAY;
    private GodSquareHotGodAdapter jUA;
    private d jUy;
    private GodSquareRecGodAdapter jUz;

    public List<com.baidu.adp.widget.ListView.a> bUR() {
        return this.boM;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        this.jUy = new d(tbPageContext);
        this.jUz = new GodSquareRecGodAdapter(tbPageContext);
        this.jUA = new GodSquareHotGodAdapter(tbPageContext);
        this.boM.add(this.jUy);
        this.boM.add(this.jUz);
        this.boM.add(this.jUA);
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
