package com.baidu.tieba.godSquare.adapter;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.e;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private BdTypeListView gAY;
    private d jZL;
    private GodSquareRecGodAdapter jZM;
    private GodSquareHotGodAdapter jZN;

    public List<com.baidu.adp.widget.ListView.a> bRQ() {
        return this.boS;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gAY = bdTypeListView;
        this.jZL = new d(tbPageContext);
        this.jZM = new GodSquareRecGodAdapter(tbPageContext);
        this.jZN = new GodSquareHotGodAdapter(tbPageContext);
        this.boS.add(this.jZL);
        this.boS.add(this.jZM);
        this.boS.add(this.jZN);
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof e)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }
}
