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
    private final List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private e efO;
    private BdTypeListView fCT;
    private a fCU;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fCV;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fCW;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efO = tbPageContext;
        this.fCT = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.fCW = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.efO);
        this.fCW.setFrom(1);
        this.fCV = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.efO);
        this.fCV.setFrom(1);
        this.fCU = new a((TbPageContext) this.efO, com.baidu.tieba.ala.alasquare.live.b.b.fDa);
        this.bbw.add(this.fCW);
        this.bbw.add(this.fCV);
        this.bbw.add(this.fCU);
        this.fCT.addAdapters(this.bbw);
    }

    public void setDatas(List<q> list) {
        if (this.fCT != null) {
            this.fCT.setData(list);
        }
    }

    public void sz(int i) {
        this.fCW.sz(i);
        this.fCV.sz(i);
    }

    public void notifyDataSetChanged() {
        if (this.fCT != null && (this.fCT.getAdapter() instanceof BaseAdapter)) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fCU.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fCW.b(iVar);
        this.fCV.b(iVar);
    }
}
