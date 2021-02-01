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
    private BdTypeListView gzb;
    private a gzc;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gzd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gze;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eVB = tbPageContext;
        this.gzb = bdTypeListView;
        Kw();
    }

    private void Kw() {
        this.gze = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eVB);
        this.gze.setFrom(1);
        this.gzd = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eVB);
        this.gzd.setFrom(1);
        this.gzc = new a((TbPageContext) this.eVB, com.baidu.tieba.ala.alasquare.live.b.b.gzi);
        this.bns.add(this.gze);
        this.bns.add(this.gzd);
        this.bns.add(this.gzc);
        this.gzb.addAdapters(this.bns);
    }

    public void setDatas(List<n> list) {
        if (this.gzb != null) {
            this.gzb.setData(list);
        }
    }

    public void tG(int i) {
        this.gze.tG(i);
        this.gzd.tG(i);
    }

    public void notifyDataSetChanged() {
        if (this.gzb != null && (this.gzb.getAdapter() instanceof BaseAdapter)) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gzc.a(iAlaSquareTabController);
    }

    public void a(g gVar) {
        this.gze.b(gVar);
        this.gzd.b(gVar);
    }
}
