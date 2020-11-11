package com.baidu.tieba.godSquare.a;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.f;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.divider.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes24.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private BdTypeListView gih;
    private d jsX;
    private c jsY;
    private b jsZ;

    public List<com.baidu.adp.widget.ListView.a> bPj() {
        return this.bky;
    }

    public a(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.gih = bdTypeListView;
        this.jsX = new d(tbPageContext);
        this.jsY = new c(tbPageContext);
        this.jsZ = new b(tbPageContext);
        this.bky.add(this.jsX);
        this.bky.add(this.jsY);
        this.bky.add(this.jsZ);
    }

    public void notifyDataSetChanged() {
        if (this.gih != null && (this.gih.getAdapter() instanceof f)) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }
}
