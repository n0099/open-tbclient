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
    private e cVD;
    private BdTypeListView ekb;
    private a ekc;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b eke;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cVD = tbPageContext;
        this.ekb = bdTypeListView;
        wM();
    }

    private void wM() {
        this.eke = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cVD);
        this.eke.setFrom(1);
        this.ekd = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cVD);
        this.ekd.setFrom(1);
        this.ekc = new a((TbPageContext) this.cVD, com.baidu.tieba.ala.alasquare.live.b.b.eki);
        this.asE.add(this.eke);
        this.asE.add(this.ekd);
        this.asE.add(this.ekc);
        this.ekb.addAdapters(this.asE);
    }

    public void setDatas(List<m> list) {
        if (this.ekb != null) {
            this.ekb.setData(list);
        }
    }

    public void oB(int i) {
        this.eke.oB(i);
        this.ekd.oB(i);
    }

    public void notifyDataSetChanged() {
        if (this.ekb != null && (this.ekb.getAdapter() instanceof BaseAdapter)) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ekc.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.eke.b(iVar);
        this.ekd.b(iVar);
    }
}
