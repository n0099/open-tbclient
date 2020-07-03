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
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private e dPR;
    private BdTypeListView fml;
    private a fmm;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fmn;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fmo;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dPR = tbPageContext;
        this.fml = bdTypeListView;
        Dz();
    }

    private void Dz() {
        this.fmo = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dPR);
        this.fmo.setFrom(1);
        this.fmn = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dPR);
        this.fmn.setFrom(1);
        this.fmm = new a((TbPageContext) this.dPR, com.baidu.tieba.ala.alasquare.live.b.b.fms);
        this.aUP.add(this.fmo);
        this.aUP.add(this.fmn);
        this.aUP.add(this.fmm);
        this.fml.addAdapters(this.aUP);
    }

    public void setDatas(List<q> list) {
        if (this.fml != null) {
            this.fml.setData(list);
        }
    }

    public void pY(int i) {
        this.fmo.pY(i);
        this.fmn.pY(i);
    }

    public void notifyDataSetChanged() {
        if (this.fml != null && (this.fml.getAdapter() instanceof BaseAdapter)) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fmm.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fmo.b(iVar);
        this.fmn.b(iVar);
    }
}
