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
    private final List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private e cVR;
    private BdTypeListView ekE;
    private a ekF;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a ekG;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b ekH;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.cVR = tbPageContext;
        this.ekE = bdTypeListView;
        wR();
    }

    private void wR() {
        this.ekH = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.cVR);
        this.ekH.setFrom(1);
        this.ekG = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.cVR);
        this.ekG.setFrom(1);
        this.ekF = new a((TbPageContext) this.cVR, com.baidu.tieba.ala.alasquare.live.b.b.ekL);
        this.asP.add(this.ekH);
        this.asP.add(this.ekG);
        this.asP.add(this.ekF);
        this.ekE.addAdapters(this.asP);
    }

    public void setDatas(List<m> list) {
        if (this.ekE != null) {
            this.ekE.setData(list);
        }
    }

    public void oD(int i) {
        this.ekH.oD(i);
        this.ekG.oD(i);
    }

    public void notifyDataSetChanged() {
        if (this.ekE != null && (this.ekE.getAdapter() instanceof BaseAdapter)) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.ekF.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.ekH.b(iVar);
        this.ekG.b(iVar);
    }
}
