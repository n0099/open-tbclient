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
    private final List<com.baidu.adp.widget.ListView.a> aWf = new ArrayList();
    private e dWk;
    private BdTypeListView frv;
    private a frw;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a frx;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fry;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.dWk = tbPageContext;
        this.frv = bdTypeListView;
        DS();
    }

    private void DS() {
        this.fry = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.dWk);
        this.fry.setFrom(1);
        this.frx = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.dWk);
        this.frx.setFrom(1);
        this.frw = new a((TbPageContext) this.dWk, com.baidu.tieba.ala.alasquare.live.b.b.frC);
        this.aWf.add(this.fry);
        this.aWf.add(this.frx);
        this.aWf.add(this.frw);
        this.frv.addAdapters(this.aWf);
    }

    public void setDatas(List<q> list) {
        if (this.frv != null) {
            this.frv.setData(list);
        }
    }

    public void qn(int i) {
        this.fry.qn(i);
        this.frx.qn(i);
    }

    public void notifyDataSetChanged() {
        if (this.frv != null && (this.frv.getAdapter() instanceof BaseAdapter)) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.frw.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fry.b(iVar);
        this.frx.b(iVar);
    }
}
