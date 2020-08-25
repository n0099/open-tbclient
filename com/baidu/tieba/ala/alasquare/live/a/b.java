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
    private final List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private e efK;
    private BdTypeListView fCP;
    private a fCQ;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fCR;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fCS;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.efK = tbPageContext;
        this.fCP = bdTypeListView;
        Jv();
    }

    private void Jv() {
        this.fCS = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.efK);
        this.fCS.setFrom(1);
        this.fCR = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.efK);
        this.fCR.setFrom(1);
        this.fCQ = new a((TbPageContext) this.efK, com.baidu.tieba.ala.alasquare.live.b.b.fCW);
        this.bbu.add(this.fCS);
        this.bbu.add(this.fCR);
        this.bbu.add(this.fCQ);
        this.fCP.addAdapters(this.bbu);
    }

    public void setDatas(List<q> list) {
        if (this.fCP != null) {
            this.fCP.setData(list);
        }
    }

    public void sz(int i) {
        this.fCS.sz(i);
        this.fCR.sz(i);
    }

    public void notifyDataSetChanged() {
        if (this.fCP != null && (this.fCP.getAdapter() instanceof BaseAdapter)) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fCQ.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fCS.b(iVar);
        this.fCR.b(iVar);
    }
}
