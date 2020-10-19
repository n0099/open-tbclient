package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private BdTypeListView fSo;
    private d jaF;
    private c jaG;
    private b jaH;

    public List<com.baidu.adp.widget.ListView.a> bKh() {
        return this.bhH;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.fSo = bdTypeListView;
        this.jaF = new d(tbPageContext);
        this.jaG = new c(tbPageContext);
        this.jaH = new b(tbPageContext);
        this.bhH.add(this.jaF);
        this.bhH.add(this.jaG);
        this.bhH.add(this.jaH);
    }

    public void notifyDataSetChanged() {
        if (this.fSo != null && (this.fSo.getAdapter() instanceof f)) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }
}
