package com.baidu.tieba.ala.alasquare.live.a;

import android.widget.BaseAdapter;
import com.baidu.adp.base.e;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.ala.square.IAlaSquareTabController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.alasquare.subtablist.c.i;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b {
    private final List<com.baidu.adp.widget.ListView.a> aSj = new ArrayList();
    private e dJb;
    private BdTypeListView fbb;
    private a fbc;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fbd;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fbe;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dJb = tbPageContext;
        this.fbb = bdTypeListView;
        CY();
    }

    private void CY() {
        this.fbe = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dJb);
        this.fbe.setFrom(1);
        this.fbd = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dJb);
        this.fbd.setFrom(1);
        this.fbc = new a((TbPageContext) this.dJb, com.baidu.tieba.ala.alasquare.live.b.b.fbi);
        this.aSj.add(this.fbe);
        this.aSj.add(this.fbd);
        this.aSj.add(this.fbc);
        this.fbb.addAdapters(this.aSj);
    }

    public void setDatas(List<o> list) {
        if (this.fbb != null) {
            this.fbb.setData(list);
        }
    }

    public void pz(int i) {
        this.fbe.pz(i);
        this.fbd.pz(i);
    }

    public void notifyDataSetChanged() {
        if (this.fbb != null && (this.fbb.getAdapter() instanceof BaseAdapter)) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fbc.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fbe.b(iVar);
        this.fbd.b(iVar);
    }
}
