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
    private final List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private e eid;
    private BdTypeListView fGf;
    private a fGg;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fGh;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fGi;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eid = tbPageContext;
        this.fGf = bdTypeListView;
        JZ();
    }

    private void JZ() {
        this.fGi = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eid);
        this.fGi.setFrom(1);
        this.fGh = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eid);
        this.fGh.setFrom(1);
        this.fGg = new a((TbPageContext) this.eid, com.baidu.tieba.ala.alasquare.live.b.b.fGm);
        this.bdV.add(this.fGi);
        this.bdV.add(this.fGh);
        this.bdV.add(this.fGg);
        this.fGf.addAdapters(this.bdV);
    }

    public void setDatas(List<q> list) {
        if (this.fGf != null) {
            this.fGf.setData(list);
        }
    }

    public void sR(int i) {
        this.fGi.sR(i);
        this.fGh.sR(i);
    }

    public void notifyDataSetChanged() {
        if (this.fGf != null && (this.fGf.getAdapter() instanceof BaseAdapter)) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fGg.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fGi.b(iVar);
        this.fGh.b(iVar);
    }
}
