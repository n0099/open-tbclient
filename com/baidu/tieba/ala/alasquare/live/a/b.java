package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private e cVC;
    private BdTypeListView eka;
    private a ekb;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekc;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekd;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cVC = tbPageContext;
        this.eka = bdTypeListView;
        wM();
    }

    private void wM() {
        this.ekd = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cVC);
        this.ekd.setFrom(1);
        this.ekc = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cVC);
        this.ekc.setFrom(1);
        this.ekb = new a((TbPageContext) this.cVC, com.baidu.tieba.ala.alasquare.live.b.b.ekh);
        this.asE.add(this.ekd);
        this.asE.add(this.ekc);
        this.asE.add(this.ekb);
        this.eka.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.eka != null) {
            this.eka.setData(list);
        }
    }

    public void oB(int i) {
        this.ekd.oB(i);
        this.ekc.oB(i);
    }

    public void notifyDataSetChanged() {
        if (this.eka != null && (this.eka.getAdapter() instanceof BaseAdapter)) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ekb.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.ekd.b(iVar);
        this.ekc.b(iVar);
    }
}
