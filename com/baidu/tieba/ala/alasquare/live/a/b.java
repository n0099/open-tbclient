package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.h;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> agy = new ArrayList();
    private e ceS;
    private BdTypeListView duK;
    private a duL;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a duM;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b duN;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.ceS = tbPageContext;
        this.duK = bdTypeListView;
        sY();
    }

    private void sY() {
        this.duN = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.ceS);
        this.duN.setFrom(1);
        this.duM = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.ceS);
        this.duM.setFrom(1);
        this.duL = new a((TbPageContext) this.ceS, com.baidu.tieba.ala.alasquare.live.b.b.duR);
        this.agy.add(this.duN);
        this.agy.add(this.duM);
        this.agy.add(this.duL);
        this.duK.addAdapters(this.agy);
    }

    public void setDatas(List<m> list) {
        if (this.duK != null) {
            this.duK.setData(list);
        }
    }

    public void mb(int i) {
        this.duN.mb(i);
        this.duM.mb(i);
    }

    public void notifyDataSetChanged() {
        if (this.duK != null && (this.duK.getAdapter() instanceof BaseAdapter)) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.duL.a(iAlaSquareTabController);
    }

    public void a(h hVar) {
        this.duN.b(hVar);
        this.duM.b(hVar);
    }
}
