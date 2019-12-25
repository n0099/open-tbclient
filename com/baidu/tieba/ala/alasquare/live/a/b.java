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
/* loaded from: classes2.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aoz = new ArrayList();
    private e cRq;
    private BdTypeListView efM;
    private a efN;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a efO;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b efP;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cRq = tbPageContext;
        this.efM = bdTypeListView;
        uR();
    }

    private void uR() {
        this.efP = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cRq);
        this.efP.setFrom(1);
        this.efO = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cRq);
        this.efO.setFrom(1);
        this.efN = new a((TbPageContext) this.cRq, com.baidu.tieba.ala.alasquare.live.b.b.efT);
        this.aoz.add(this.efP);
        this.aoz.add(this.efO);
        this.aoz.add(this.efN);
        this.efM.addAdapters(this.aoz);
    }

    public void setDatas(List<m> list) {
        if (this.efM != null) {
            this.efM.setData(list);
        }
    }

    public void ok(int i) {
        this.efP.ok(i);
        this.efO.ok(i);
    }

    public void notifyDataSetChanged() {
        if (this.efM != null && (this.efM.getAdapter() instanceof BaseAdapter)) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.efN.a(iAlaSquareTabController);
    }

    public void a(h hVar) {
        this.efP.b(hVar);
        this.efO.b(hVar);
    }
}
