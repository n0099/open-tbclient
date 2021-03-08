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
/* loaded from: classes9.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> boS = new ArrayList();
    private f eXa;
    private BdTypeListView gAY;
    private a gAZ;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a gBa;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b gBb;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eXa = tbPageContext;
        this.gAY = bdTypeListView;
        Kz();
    }

    private void Kz() {
        this.gBb = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eXa);
        this.gBb.setFrom(1);
        this.gBa = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eXa);
        this.gBa.setFrom(1);
        this.gAZ = new a((TbPageContext) this.eXa, com.baidu.tieba.ala.alasquare.live.b.b.gBf);
        this.boS.add(this.gBb);
        this.boS.add(this.gBa);
        this.boS.add(this.gAZ);
        this.gAY.addAdapters(this.boS);
    }

    public void setDatas(List<n> list) {
        if (this.gAY != null) {
            this.gAY.setData(list);
        }
    }

    public void tI(int i) {
        this.gBb.tI(i);
        this.gBa.tI(i);
    }

    public void notifyDataSetChanged() {
        if (this.gAY != null && (this.gAY.getAdapter() instanceof BaseAdapter)) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.gAZ.a(iAlaSquareTabController);
    }

    public void a(g gVar) {
        this.gBb.b(gVar);
        this.gBa.b(gVar);
    }
}
