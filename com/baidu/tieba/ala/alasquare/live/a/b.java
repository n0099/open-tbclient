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
    private final List<com.baidu.adp.widget.ListView.a> agQ = new ArrayList();
    private e cfJ;
    private BdTypeListView dvB;
    private a dvC;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a dvD;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b dvE;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cfJ = tbPageContext;
        this.dvB = bdTypeListView;
        sX();
    }

    private void sX() {
        this.dvE = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cfJ);
        this.dvE.setFrom(1);
        this.dvD = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cfJ);
        this.dvD.setFrom(1);
        this.dvC = new a((TbPageContext) this.cfJ, com.baidu.tieba.ala.alasquare.live.b.b.dvI);
        this.agQ.add(this.dvE);
        this.agQ.add(this.dvD);
        this.agQ.add(this.dvC);
        this.dvB.addAdapters(this.agQ);
    }

    public void setDatas(List<m> list) {
        if (this.dvB != null) {
            this.dvB.setData(list);
        }
    }

    public void mc(int i) {
        this.dvE.mc(i);
        this.dvD.mc(i);
    }

    public void notifyDataSetChanged() {
        if (this.dvB != null && (this.dvB.getAdapter() instanceof BaseAdapter)) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.dvC.a(iAlaSquareTabController);
    }

    public void a(h hVar) {
        this.dvE.b(hVar);
        this.dvD.b(hVar);
    }
}
