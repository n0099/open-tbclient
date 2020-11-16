package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private e eGT;
    private BdTypeListView ghN;
    private a ghO;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ghP;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ghQ;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eGT = tbPageContext;
        this.ghN = bdTypeListView;
        Lp();
    }

    private void Lp() {
        this.ghQ = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eGT);
        this.ghQ.setFrom(1);
        this.ghP = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eGT);
        this.ghP.setFrom(1);
        this.ghO = new a((TbPageContext) this.eGT, com.baidu.tieba.ala.alasquare.live.b.b.ghU);
        this.biN.add(this.ghQ);
        this.biN.add(this.ghP);
        this.biN.add(this.ghO);
        this.ghN.addAdapters(this.biN);
    }

    public void setDatas(List<q> list) {
        if (this.ghN != null) {
            this.ghN.setData(list);
        }
    }

    public void uq(int i) {
        this.ghQ.uq(i);
        this.ghP.uq(i);
    }

    public void notifyDataSetChanged() {
        if (this.ghN != null && (this.ghN.getAdapter() instanceof BaseAdapter)) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ghO.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.ghQ.b(iVar);
        this.ghP.b(iVar);
    }
}
