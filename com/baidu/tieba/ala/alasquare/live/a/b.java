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
    private final List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private e eul;
    private BdTypeListView fSo;
    private a fSp;
    private com.baidu.tieba.ala.alasquare.subtablist.a.a fSq;
    private com.baidu.tieba.ala.alasquare.subtablist.a.b fSr;

    public b(TbPageContext<?> tbPageContext, BdTypeListView bdTypeListView) {
        this.eul = tbPageContext;
        this.fSo = bdTypeListView;
        Le();
    }

    private void Le() {
        this.fSr = new com.baidu.tieba.ala.alasquare.subtablist.a.b((TbPageContext) this.eul);
        this.fSr.setFrom(1);
        this.fSq = new com.baidu.tieba.ala.alasquare.subtablist.a.a((TbPageContext) this.eul);
        this.fSq.setFrom(1);
        this.fSp = new a((TbPageContext) this.eul, com.baidu.tieba.ala.alasquare.live.b.b.fSv);
        this.bhH.add(this.fSr);
        this.bhH.add(this.fSq);
        this.bhH.add(this.fSp);
        this.fSo.addAdapters(this.bhH);
    }

    public void setDatas(List<q> list) {
        if (this.fSo != null) {
            this.fSo.setData(list);
        }
    }

    public void tp(int i) {
        this.fSr.tp(i);
        this.fSq.tp(i);
    }

    public void notifyDataSetChanged() {
        if (this.fSo != null && (this.fSo.getAdapter() instanceof BaseAdapter)) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void a(IAlaSquareTabController iAlaSquareTabController) {
        this.fSp.a(iAlaSquareTabController);
    }

    public void a(i iVar) {
        this.fSr.b(iVar);
        this.fSq.b(iVar);
    }
}
