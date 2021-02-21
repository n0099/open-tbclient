package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.f;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private f eVB;
    private BdTypeListView gzp;
    private a gzq;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gzr;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gzs;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eVB = tbPageContext;
        this.gzp = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.gzs = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eVB);
        this.gzs.setFrom(1);
        this.gzr = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eVB);
        this.gzr.setFrom(1);
        this.gzq = new a((TbPageContext) this.eVB, com.baidu.tieba.ala.alasquare.live.b.b.gzw);
        this.bns.add(this.gzs);
        this.bns.add(this.gzr);
        this.bns.add(this.gzq);
        this.gzp.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gzp != null) {
            this.gzp.setData(list);
        }
    }

    public void tG(int i) {
        this.gzs.tG(i);
        this.gzr.tG(i);
    }

    public void notifyDataSetChanged() {
        if (this.gzp != null && (this.gzp.getAdapter() instanceof BaseAdapter)) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gzq.a(iAlaSquareTabController);
    }

    public void a(g gVar) {
        this.gzs.b(gVar);
        this.gzr.b(gVar);
    }
}
